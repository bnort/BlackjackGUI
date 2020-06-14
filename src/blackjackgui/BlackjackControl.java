/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author bnort
 */
public class BlackjackControl implements ActionListener {
    
    BlackjackModel model;
    BlackjackView view;
    
    BlackjackControl() {
        System.out.println("Controller()");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        System.out.println("Controller: acting on Model");
        
        if (ac.equalsIgnoreCase("play")){
            jButtonPlayActionPerformed(e);
        }
        if (ac.equalsIgnoreCase("choose user")){
            jButtonUserActionPerformed(e);
        }
        if (ac.equalsIgnoreCase("exit")){
            jButtonExitActionPerformed(e);
        }
        if (ac.equalsIgnoreCase("main menu")){
            jButtonMainMenuReturnActionPerformed(e);
        }
        if (ac.equalsIgnoreCase("hit")){
            jButtonHitActionPerformed(e);
        }
        if (ac.equalsIgnoreCase("stand")){
            jButtonStandActionPerformed(e);
        }
    }
    
    private void jButtonPlayActionPerformed(ActionEvent e) {
        model.updateMenus(1);
        model.startPlaying();
        model.initialHandSetup();
    }
    
    private void jButtonUserActionPerformed(ActionEvent e) {
        model.updateMenus(2);
    }
    
    private void jButtonMainMenuReturnActionPerformed(ActionEvent e) {
        model.updateMenus(3);
        model.clearBoard();
    }
    
    private void jButtonExitActionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
    private void jButtonHitActionPerformed(ActionEvent e) {
        model.dealCard();
    }
    
    private void jButtonStandActionPerformed(ActionEvent e) {
        model.playerStand();
    }
    
    public void addModel(BlackjackModel m) {
        System.out.println("Controller: adding model");
        this.model = m;
    }

    public void addView(BlackjackView v) {
        System.out.println("Controller: adding view");
        this.view = v;
    }
}
