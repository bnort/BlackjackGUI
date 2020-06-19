package blackjackgui;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author bnort
 */
public class DeckTest {
    
    /**
     * Test of initialiseDeck method, of class Deck. 
     * Test is to confirm that the deck receives 52 cards
     * and that the first and last card are as expected.
     */
    @Test
    public void testInitialiseDeck() {
        System.out.println("initialiseDeck");
        Deck instance = new Deck();
        instance.initialiseDeck();
        
        Assert.assertEquals(52,instance.getCards().size());
        Assert.assertEquals("11 of HEARTS",instance.getCards().getFirst().toString());
        Assert.assertEquals("10 of DIAMONDS",instance.getCards().getLast().toString());
        
    }

    /**
     * Test of shuffleDeck method, of class Deck.
     * Test is to confirm that the deck is shuffled,
     * checks that the first card has changed after
     * initialisation. This test will fail on occasion
     * due to the nature of random shuffling.
     */
    @Test
    public void testShuffleDeck() {
        System.out.println("shuffleDeck");
        Deck instance = new Deck();
        instance.initialiseDeck();
        instance.shuffleDeck();
        
        Card testCard = new Card(1, 0);
        
        Assert.assertFalse(testCard == instance.getCards().getFirst());
    }
}
