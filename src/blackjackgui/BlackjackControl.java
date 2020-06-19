package blackjackgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for this project.
 * 
 * @author BretNorton 0948797
 */
public class BlackjackControl implements ActionListener {
    
    BlackjackModel model;
    BlackjackView view;
    
    BlackjackControl() {
        //System.out.println("Controller()");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        //System.out.println("Controller: acting on Model");

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
    
    /**
     * Check to see if a user has been chosen.
     * If not: Open user choosing dialog.
     * If so: Commence playing the game.
     */
    private void jButtonPlayActionPerformed(ActionEvent e) {
        if(model.checkUser()) {
            model.updateMenus(1);
            model.startPlaying();
            model.initialHandSetup();
        }
        else
            model.openUserDialog();
    }
    
    /**
     * Return to main menu clearing blackjack board in the process.
     */
    private void jButtonMainMenuReturnActionPerformed(ActionEvent e) {
        model.updateMenus(3);
        model.clearBoard();
        model.closeResultDialog();
    }
    
    /**
     * Draw a card.
     */
    private void jButtonHitActionPerformed(ActionEvent e) {
        model.dealCard();
    }
    
    /**
     * Stand as player.
     */
    private void jButtonStandActionPerformed(ActionEvent e) {
        model.playerStand();
    }
    
    /**
     * Move to next hand.
     */
    private void jButtonNextHandActionPerformed(ActionEvent e) {
        model.clearBoard();
        model.closeResultDialog();
        model.initialHandSetup();
    }
    
    /**
     * Open bet size dialog.
     */
    private void jButtonChangeBetActionPerformed(ActionEvent e) {
        model.openBetDialog();
    }
    
    /**
     * Enter username.
     */
    private void jTextFieldChooseUserActionPerformed(String s) {
        model.chooseUser(s);
        model.closeUserDialog();
    }
    
    /**
     * Reload credits after reaching 0.
     */
    private void jButtonZeroCreditsYesActionPerformed(ActionEvent e) {
        model.reloadCredits();
        model.closeZeroCreditsDialog();
        model.clearBoard();
        model.closeResultDialog();
        model.initialHandSetup();
    }
    
    /**
     * Remove user from database and leave game after reaching 0 credits.
     */
    private void jButtonZeroCreditsNoActionPerformed(ActionEvent e) {
        model.deleteUser();
        System.exit(0);
    }
    
    /**
     * Change bet size.
     */
    private void jButtonBetConfirmActionPerformed(ActionEvent e) {
        model.changeBetSize(view.sliderInt);
        model.closeBetDialog();
    }
    
    public void addModel(BlackjackModel m) {
        //System.out.println("Controller: adding model");
        this.model = m;
    }

    public void addView(BlackjackView v) {
        //System.out.println("Controller: adding view");
        this.view = v;
    }
}
