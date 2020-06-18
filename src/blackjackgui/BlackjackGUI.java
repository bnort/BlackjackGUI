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
        BlackjackDB BJDB = new BlackjackDB();
        
        BJModel.addDatabase(BJDB);
        BJModel.addObserver(BJView);
        
        BlackjackControl BJController = new BlackjackControl();
        BJController.addModel(BJModel);
        BJController.addView(BJView);
        BJView.addController(BJController);
        BJView.setVisible(true);
        BJModel.addDatabase(BJDB);
    }
}
