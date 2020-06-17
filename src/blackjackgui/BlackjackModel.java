/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgui;

import java.awt.Image;
import java.util.LinkedList;
import java.util.Observable;
import javax.swing.*;

/**
 *
 * @author bnort
 */
public class BlackjackModel extends Observable {
    
    Deck currentDeck = new Deck();
    LinkedList<Card> cards = new LinkedList<Card>();
    Card nextCard = null;
    private Hand playerHand;
    private Hand dealerHand;
    private int betSize = 25;
    User user = null;
    String resultString;
    BlackjackDB BJDB;
    
    public void startPlaying()
    {
        currentDeck.initialiseDeck();
        currentDeck.shuffleDeck();
        updateCredits();
    }
    
    public void initialHandSetup()
    {
        currentDeck.shuffleCheck();
        playerHand = new Hand(false);
        dealerHand = new Hand(true);
        for(int i = 0; i < 3; i++)
        {
            nextCard = currentDeck.drawCard();
            JLabel cardLabel = new JLabel();
            cardLabel.setIcon(scaleImage(nextCard.getPic()));
            if ((i % 2) == 0)
            {
                getPlayerHand().getHand().add(nextCard);
                setChanged();
                notifyObservers(cardLabel);
            }
            else
            {
                getDealerHand().getHand().add(nextCard);
                setChanged();
                notifyObservers(cardLabel.getIcon());
            }
        }
        
        setChanged();
        notifyObservers(playerHand);
        setChanged();
        notifyObservers(dealerHand);
        
        blackjackCheck(playerHand);
    }
    
    public void dealCard()
    {
        nextCard = currentDeck.drawCard();
        JLabel cardLabel = new JLabel();
        cardLabel.setIcon(scaleImage(nextCard.getPic()));
        getPlayerHand().getHand().add(nextCard);
             
        setChanged();
        notifyObservers(cardLabel);
        setChanged();
        notifyObservers(playerHand);
        
        bustCheck(playerHand);
        
        if(playerHand.isBustFlag())
        {
            resultString = "Sorry, you busted.";
            user.adjustCredits(-betSize);
            openResultFrame(resultString);
        }
    }
    
    public void playerStand()
    {
        playerHand.setStandFlag(true);
        
        dealerShitGO();
    }
    
    public void dealerShitGO()
    {
        while(dealerHand.calculateTotal() < 17)
        {
            nextCard = currentDeck.drawCard();
            JLabel cardLabel = new JLabel();
            cardLabel.setIcon(scaleImage(nextCard.getPic()));
            dealerHand.getHand().add(nextCard);
            
            setChanged();
            notifyObservers(cardLabel.getIcon());
        }
        
        bustCheck(dealerHand);
        
        setChanged();
        notifyObservers(dealerHand);
        
        if(!dealerHand.isBustFlag())
            compareTotal();
        else
        {
            resultString = "Dealer has busted, you win!";
            user.adjustCredits(betSize);
            openResultFrame(resultString);
        }
    }
    
    public void compareTotal()
    {
        
        int result = playerHand.calculateTotal() - dealerHand.calculateTotal();
        if(result > 0)
        {
            resultString = "Congratulations, you win!";
            user.adjustCredits(betSize);
        }
        else if(result < 0)
        {
            resultString = "The dealer has a higher score, you lost!";
            user.adjustCredits(-betSize);
        }
        else
        {
            resultString = "You tied with the dealer.";
        }
        
        openResultFrame(resultString);
    }
    
    public boolean blackjackCheck(Hand handToCheck)
    {
        if(handToCheck.calculateTotal() == 21)
        {
            resultString = "Wow you got a blackjack! Nice job!";
            openResultFrame(resultString);
            
            user.adjustCredits(betSize + (betSize/2));
            updateCredits();
            return true;
        }
        else
            return false;
    }
    
    public void bustCheck(Hand handToCheck)
    {
        if(handToCheck.calculateTotal() > 21)
            handToCheck.setBustFlag(true);
    }
    
    public void chooseUser(String userName)
    {
        this.user = new User(userName);
        BJDB.addUser(userName);
        user.setCredits(BJDB.getCredits(user.getName()));
    }
    
    public void updateMenus(Object obj)
    {
        switch((int)obj)
        {
            case 1:
                obj = "playCard";
                break;
            case 2:
                obj = "userCard";
                break;
            case 3:
                obj = "mainMenuCard";
                break;
        }
        
        setChanged();
        notifyObservers(obj);
    }
    
    public void updateCredits()
    {
        String credits = "You have " + user.getCredits() + " credits.";
        setChanged();
        notifyObservers(credits);
    }
    
    public void clearBoard()
    {
        setChanged();
        notifyObservers(1);
    }
    
    public void changeBetSize(Integer i)
    {
        this.betSize = i;
    }
    
    public void openResultFrame(String result)
    {
        updateCredits();
        setChanged();
        notifyObservers(result);
        setChanged();
        notifyObservers(50);
    }
    
    public void closeResultFrame()
    {
        setChanged();
        notifyObservers(98);
    }
    
    public static ImageIcon scaleImage(ImageIcon i) {
        Image image = i.getImage();
        Image newImg = image.getScaledInstance(70, 106, java.awt.Image.SCALE_SMOOTH);
        
        return new ImageIcon(newImg);
    }
    
    public void openBetFrame()
    {
        setChanged();
        notifyObservers(51);
    }
    
    public void closeBetFrame()
    {
        setChanged();
        notifyObservers(99);
    }

    /**
     * @return the playerHand
     */
    public Hand getPlayerHand() {
        return playerHand;
    }

    /**
     * @return the dealerHand
     */
    public Hand getDealerHand() {
        return dealerHand;
    }
    
    public void addDatabase(BlackjackDB BJDB) {
        System.out.println("Controller: adding DB");
        this.BJDB = BJDB;
    }
}
