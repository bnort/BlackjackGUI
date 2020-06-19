/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgui;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author bnort
 */
public class BlackjackModelTest {

    /**
     * Test of bustCheck method, of class BlackjackModel.
     * Test to confirm that hands get flagged as busted
     * correctly. 8 cards will always bust with only 1 deck
     * of cards so should always return a true bust flag.
     */
    @Test
    public void testBustCheck() {
        System.out.println("bustCheck");
        BlackjackModel instance = new BlackjackModel();
        Hand handToCheck = new Hand(false);
        Deck testDeck = new Deck();
        testDeck.initialiseDeck();
        testDeck.shuffleDeck();
        for(int i = 0; i < 8; i++)
            handToCheck.getHand().add(testDeck.drawCard());
        instance.bustCheck(handToCheck);
        Assert.assertTrue(handToCheck.isBustFlag());
    }
}
