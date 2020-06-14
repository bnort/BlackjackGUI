package blackjackgui;

/**
 *
 * @author bnort
 */
public class BlackjackGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BlackjackGUI mainBlackjackGUI = new BlackjackGUI();
    }
    
    public BlackjackGUI() {
        BlackjackModel BJModel = new BlackjackModel();
        BlackjackView BJView = new BlackjackView();
        
        BJModel.addObserver(BJView);
        
        BlackjackControl BJController = new BlackjackControl();
        BJController.addModel(BJModel);
        BJController.addView(BJView);
        BJView.addController(BJController);
        BJView.setVisible(true);
    }
}