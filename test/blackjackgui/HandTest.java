/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgui;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bnort
 */
public class HandTest {

    /**
     * Test of calculateTotal method, of class Hand.
     * Test to confirm that the class is calculating hand
     * totals correctly.
     */
    @Test
    public void testCalculateTotal() {
        System.out.println("calculateTotal");
        Deck testDeck = new Deck();
        testDeck.initialiseDeck();
        Hand instance = new Hand(false);
        instance.getHand().add(testDeck.drawCard());
        instance.getHand().add(testDeck.drawCard());
        instance.getHand().add(testDeck.drawCard());
        instance.getHand().add(testDeck.drawCard());
        int expResult = 20;
        int result = instance.calculateTotal();
        Assert.assertEquals(expResult, result);
    }

}
