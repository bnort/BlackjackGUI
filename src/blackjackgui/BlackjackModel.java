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
    
    Deck tester = new Deck();
    LinkedList<Card> cards = new LinkedList<Card>();
    Card nextCard = null;
    private Hand playerHand;
    private Hand dealerHand;
    private int betSize;
    
    public void startPlaying()
    {
        tester.initialiseDeck();
        tester.shuffleDeck();
    }
    
    public void initialHandSetup()
    {
        tester.shuffleCheck();
        playerHand = new Hand();
        dealerHand = new Hand();
        for(int i = 0; i < 3; i++)
        {
            nextCard = tester.drawCard();
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
        
        blackjackCheck(playerHand);
    }
    
    public void dealCard()
    {
        nextCard = tester.drawCard();
        JLabel cardLabel = new JLabel();
        cardLabel.setIcon(scaleImage(nextCard.getPic()));
        getPlayerHand().getHand().add(nextCard);
             
        setChanged();
        notifyObservers(cardLabel);
        
        bustCheck(playerHand);
        if(playerHand.isBustFlag())
        {
            //user.adjustCredits(betSize);
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
            nextCard = tester.drawCard();
            JLabel cardLabel = new JLabel();
            cardLabel.setIcon(scaleImage(nextCard.getPic()));
            dealerHand.getHand().add(nextCard);
            
            setChanged();
            notifyObservers(cardLabel.getIcon());
            
            System.out.println("The dealer drew a(n) ");
            try {
                Thread.sleep(750);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
            System.out.println(dealerHand.getHand().getLast().getRank());
            //gameStanding();
        }
        
        bustCheck(dealerHand);
        
        /*if(!dealerHand.isBustFlag())
            compareTotal();
        else
        {
            System.out.println("Dealer has busted, you win!");
            //user.adjustCredits(betSize);
        }*/
    }
    
    public boolean blackjackCheck(Hand handToCheck)
    {
        if(handToCheck.calculateTotal() == 21)
        {
            System.out.println("Wow you got a blackjack! Nice job!");
            //user.adjustCredits(betSize + (betSize/2));
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
    
    public void clearBoard()
    {
        setChanged();
        notifyObservers(1);
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
