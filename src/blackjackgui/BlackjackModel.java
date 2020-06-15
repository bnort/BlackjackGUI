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
    public User user = new User("steve");
    
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
            user.adjustCredits(betSize);
            openResultFrame();
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
            System.out.println("Dealer has busted, you win!");
            user.adjustCredits(betSize);
            openResultFrame();
        }
    }
    
    public void compareTotal()
    {
        int result = playerHand.calculateTotal() - dealerHand.calculateTotal();
        if(result > 0)
        {
            System.out.println("Congratulations, you win!");
            user.adjustCredits(betSize);
        }
        else if(result < 0)
        {
            System.out.println("Oh no, the dealer has a higher score, you lost!");
            user.adjustCredits(-betSize);
        }
        else
        {
            System.out.println("You tied with the dealer.");
        }
        
        openResultFrame();
    }
    
    public boolean blackjackCheck(Hand handToCheck)
    {
        if(handToCheck.calculateTotal() == 21)
        {
            System.out.println("Wow you got a blackjack! Nice job!");
            
            openResultFrame();
            
            user.adjustCredits(betSize + (betSize/2));
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
    
    public void openResultFrame()
    {
        updateCredits();
        setChanged();
        notifyObservers(50);
    }
    
    public void closeResultFrame()
    {
        setChanged();
        notifyObservers(99);
    }
    
    public static ImageIcon scaleImage(ImageIcon i) {
        Image image = i.getImage();
        Image newImg = image.getScaledInstance(70, 106, java.awt.Image.SCALE_SMOOTH);
        
        return new ImageIcon(newImg);
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
}
