/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        switch (ac) {
            case "Play":
                jButtonPlayActionPerformed(e);
                break;
            case "Main Menu":
                jButtonMainMenuReturnActionPerformed(e);
                break;
            case "Hit":
                jButtonHitActionPerformed(e);
                break;
            case "Stand":
                jButtonStandActionPerformed(e);
                break;
            case "Next Hand":
                jButtonNextHandActionPerformed(e);
                break;
            case "Change Bet":
                jButtonChangeBetActionPerformed(e);
                break;
            case "Confirm":
                jButtonBetConfirmActionPerformed(e);
                break;
            case "Yes":
                jButtonZeroCreditsYesActionPerformed(e);
                break;
            case "No":
                jButtonZeroCreditsNoActionPerformed(e);
                break;
            default:
                jTextFieldChooseUserActionPerformed(ac);
        }
    }
    
    private void jButtonPlayActionPerformed(ActionEvent e) {
        if(model.checkUser()) {
            model.updateMenus(1);
            model.startPlaying();
            model.initialHandSetup();
        }
        else
            model.openUserDialog();
    }
    private void jButtonMainMenuReturnActionPerformed(ActionEvent e) {
        model.updateMenus(3);
        model.clearBoard();
        model.closeResultDialog();
    }
    
    private void jButtonHitActionPerformed(ActionEvent e) {
        model.dealCard();
    }
    
    private void jButtonStandActionPerformed(ActionEvent e) {
        model.playerStand();
    }
    
    private void jButtonNextHandActionPerformed(ActionEvent e) {
        model.clearBoard();
        model.closeResultDialog();
        model.initialHandSetup();
    }
    
    private void jButtonChangeBetActionPerformed(ActionEvent e) {
        model.openBetDialog();
    }
    
    private void jTextFieldChooseUserActionPerformed(String s) {
        model.chooseUser(s);
        model.closeUserDialog();
    }
    
    private void jButtonZeroCreditsYesActionPerformed(ActionEvent e) {
        model.reloadCredits();
        model.closeZeroCreditsDialog();
        model.clearBoard();
        model.closeResultDialog();
        model.initialHandSetup();
    }
    
    private void jButtonZeroCreditsNoActionPerformed(ActionEvent e) {
        model.deleteUser();
        System.exit(0);
    }
    
    private void jButtonBetConfirmActionPerformed(ActionEvent e) {
        model.changeBetSize(view.sliderInt);
        model.closeBetDialog();
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
