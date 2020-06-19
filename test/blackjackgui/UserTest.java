/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgui;

import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author bnort
 */
public class UserTest {
    /**
     * Test of adjustCredits method, of class User.
     * Test to confirm that credits are being adjusted
     * as expected.
     */
    @Test
    public void testAdjustCredits() {
        System.out.println("adjustCredits");
        int adjustment = 0;
        User instance = new User("");
        instance.adjustCredits(adjustment);
        
        Assert.assertEquals(instance.getCredits(), 500);
        
        adjustment = 50;
        instance.adjustCredits(adjustment);
        
        Assert.assertEquals(instance.getCredits(), 550);
        
        adjustment = -250;
        instance.adjustCredits(adjustment);
        
        Assert.assertEquals(instance.getCredits(), 300);
    }
}
