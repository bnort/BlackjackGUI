package blackjackgui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * View class for this project.
 * 
 * @author BretNorton 0948797
 */
public class BlackjackView extends javax.swing.JFrame implements Observer  {
    
    public int sliderInt;
    
    public BlackjackView() {
        initComponents();
    }
    
    /**
     * Set up GUI.
     */
    private void initComponents() {

        jDialogWinLose = new javax.swing.JDialog();
        jDialogBetChange = new javax.swing.JDialog();
        jDialogUser = new javax.swing.JDialog();
        jDialogLowCredits = new javax.swing.JDialog();
        jDialogZeroCredits = new javax.swing.JDialog();
        superPanel = new javax.swing.JPanel();
        jPanelMainMenu = new javax.swing.JPanel();
        jPanelUser = new javax.swing.JPanel();
        jPanelPlay = new javax.swing.JPanel();
        jPanelPlayMenu = new javax.swing.JPanel();
        jPanelPlayer = new javax.swing.JPanel();
        jPanelDealer = new javax.swing.JPanel();
        jPanelGameText = new javax.swing.JPanel();
        jPanelWinLose = new javax.swing.JPanel();
        jPanelBetChange = new javax.swing.JPanel();
        jPanelPadTop = new javax.swing.JPanel();
        jPanelPadBottom = new javax.swing.JPanel();
        jPanelLowCredits = new javax.swing.JPanel();
        jPanelZeroCredits = new javax.swing.JPanel();
        jButtonPlay = new javax.swing.JButton();
        jButtonUser = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonMainMenuReturnUser = new javax.swing.JButton();
        jButtonMainMenuReturnPlay = new javax.swing.JButton();
        jButtonHit = new javax.swing.JButton();
        jButtonStand = new javax.swing.JButton();
        jButtonNextHand = new javax.swing.JButton();
        jButtonChangeBetOpener = new javax.swing.JButton();
        jButtonBetConfirm = new javax.swing.JButton();
        jButtonLowCredits = new javax.swing.JButton();
        jButtonZeroCreditsYes = new javax.swing.JButton();
        jButtonZeroCreditsNo = new javax.swing.JButton();
        jLabelEnterName = new javax.swing.JLabel();
        jLabelPlayer = new javax.swing.JLabel();
        jLabelDealer = new javax.swing.JLabel();
        jLabelResult = new javax.swing.JLabel();
        jLabelCredits = new javax.swing.JLabel();
        jLabelBetSize = new javax.swing.JLabel();
        jLabelBetNumber = new javax.swing.JLabel();
        jLabelLowCredits = new javax.swing.JLabel();
        jLabelZeroCredits = new javax.swing.JLabel();
        jTextFieldChooseUser = new javax.swing.JTextField();
        jSliderBetChange = new javax.swing.JSlider();

        jDialogWinLose.setResizable(false);
        jDialogWinLose.setSize(new java.awt.Dimension(400, 100));
        jDialogWinLose.getContentPane().setLayout(new java.awt.FlowLayout());
        jDialogWinLose.setLocationRelativeTo(this);
        jDialogWinLose.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        jPanelWinLose.setLayout(new java.awt.BorderLayout());

        jLabelResult.setText("");
        jLabelResult.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelWinLose.add(jLabelResult, java.awt.BorderLayout.NORTH);

        jButtonNextHand.setText("Next Hand");
        jPanelWinLose.add(jButtonNextHand, java.awt.BorderLayout.LINE_START);

        jButtonChangeBetOpener.setText("Change Bet");
        jPanelWinLose.add(jButtonChangeBetOpener, java.awt.BorderLayout.CENTER);

        jButtonMainMenuReturnPlay.setText("Main Menu");
        jPanelWinLose.add(jButtonMainMenuReturnPlay, java.awt.BorderLayout.LINE_END);
        
        jDialogWinLose.getContentPane().add(jPanelWinLose);
        
        jDialogBetChange.setResizable(false);
        jDialogBetChange.getContentPane().setLayout(new java.awt.FlowLayout());
        jDialogBetChange.setSize(new java.awt.Dimension(400,130));
        jDialogBetChange.setLocationRelativeTo(this);
        
        jPanelBetChange.setLayout(new javax.swing.BoxLayout(jPanelBetChange, javax.swing.BoxLayout.PAGE_AXIS));

        jLabelBetSize.setText("Bet Size:");
        jLabelBetSize.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelBetChange.add(jLabelBetSize);

        jSliderBetChange.setMajorTickSpacing(20);
        jSliderBetChange.setMinorTickSpacing(1);
        jSliderBetChange.setMinimum(10);
        jSliderBetChange.setPaintTicks(true);
        jSliderBetChange.setAlignmentX(Component.CENTER_ALIGNMENT);
        jSliderBetChange.addChangeListener((ChangeEvent e) -> {
            jLabelBetNumber.setText(Integer.toString(((JSlider)e.getSource()).getValue()));
            sliderInt = ((JSlider)e.getSource()).getValue();
        });
        jPanelBetChange.add(jSliderBetChange);
        
        jButtonBetConfirm.setText("Confirm");
        jButtonBetConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelBetChange.add(jButtonBetConfirm);
        
        jLabelBetNumber.setText("");
        jLabelBetNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelBetChange.add(jLabelBetNumber);

        jDialogBetChange.getContentPane().add(jPanelBetChange);
        
        jDialogUser.setResizable(false);
        jDialogUser.getContentPane().setLayout(new java.awt.FlowLayout());
        jDialogUser.setSize(new java.awt.Dimension(200,80));
        jDialogUser.setLocationRelativeTo(this);
        
        jPanelUser.setLayout(new javax.swing.BoxLayout(jPanelUser, javax.swing.BoxLayout.PAGE_AXIS));
        
        jLabelEnterName.setText("Enter your name:");
        jLabelEnterName.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelUser.add(jLabelEnterName);
        
        jTextFieldChooseUser.setText("");
        jTextFieldChooseUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelUser.add(jTextFieldChooseUser);
        
        jDialogUser.getContentPane().add(jPanelUser);
        
        jDialogZeroCredits.setResizable(false);
        jDialogZeroCredits.getContentPane().setLayout(new java.awt.FlowLayout());
        jDialogZeroCredits.setSize(new java.awt.Dimension(250,110));
        jDialogZeroCredits.setLocationRelativeTo(this);
        
        jPanelZeroCredits.setLayout(new javax.swing.BoxLayout(jPanelZeroCredits, javax.swing.BoxLayout.PAGE_AXIS));
        
        jLabelZeroCredits.setText("You ran out of credits. Keep playing?");
        jLabelZeroCredits.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelZeroCredits.add(jLabelZeroCredits);
        
        jButtonZeroCreditsYes.setText("Yes");
        jButtonZeroCreditsYes.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelZeroCredits.add(jButtonZeroCreditsYes);
        
        jButtonZeroCreditsNo.setText("No");
        jButtonZeroCreditsNo.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelZeroCredits.add(jButtonZeroCreditsNo);
        
        jDialogZeroCredits.getContentPane().add(jPanelZeroCredits);
        
        jDialogLowCredits.setResizable(false);
        jDialogLowCredits.getContentPane().setLayout(new java.awt.FlowLayout());
        jDialogLowCredits.setSize(new java.awt.Dimension(200,80));
        jDialogLowCredits.setLocationRelativeTo(this);
        
        jPanelLowCredits.setLayout(new javax.swing.BoxLayout(jPanelLowCredits, javax.swing.BoxLayout.PAGE_AXIS));
        
        jLabelLowCredits.setText("Not enough credits.");
        jLabelLowCredits.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelLowCredits.add(jLabelLowCredits);
        
        jButtonLowCredits.setText("Back");
        jButtonLowCredits.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonLowCredits.addActionListener((ActionEvent e) -> {
            jDialogLowCredits.setVisible(false);
            jDialogBetChange.setVisible(true);
        });
        jPanelLowCredits.add(jButtonLowCredits);
        
        jDialogLowCredits.getContentPane().add(jPanelLowCredits);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(208, 208, 208));

        superPanel.setLayout(new java.awt.CardLayout());

        jPanelMainMenu.setLayout(new java.awt.GridLayout(5, 0));
        jPanelMainMenu.add(jPanelPadTop);
        
        jButtonPlay.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jButtonPlay.setText("Play");
        jButtonPlay.setDefaultCapable(false);
        jPanelMainMenu.add(jButtonPlay);

        jButtonUser.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jButtonUser.setText("Choose User");
        jButtonUser.addActionListener((ActionEvent e) -> {
            jDialogUser.setVisible(true);
        });
        jPanelMainMenu.add(jButtonUser);

        jButtonExit.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        jPanelMainMenu.add(jButtonExit);
        jPanelMainMenu.add(jPanelPadBottom);

        superPanel.add(jPanelMainMenu, "mainMenuCard");

        jLabelEnterName.setText("Please enter your name:");

        jButtonMainMenuReturnUser.setText("Main Menu");
        jButtonMainMenuReturnUser.setToolTipText("");

        jLabelPlayer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPlayer.setText("You have: ");
        jPanelGameText.add(jLabelPlayer);

        jLabelDealer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelDealer.setText("Dealer has:");
        jPanelGameText.add(jLabelDealer);
        jButtonHit.setText("Hit");
        jPanelPlayMenu.add(jButtonHit);

        jButtonStand.setText("Stand");
        jPanelPlayMenu.add(jButtonStand);
                
        jLabelCredits.setText("");
        jPanelPlayMenu.add(jLabelCredits);
        
        org.jdesktop.layout.GroupLayout jPanelPlayLayout = new org.jdesktop.layout.GroupLayout(jPanelPlay);
        jPanelPlay.setLayout(jPanelPlayLayout);
        jPanelPlayLayout.setHorizontalGroup(
            jPanelPlayLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelPlayLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelPlayLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelPlayMenu, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanelPlayer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 618, Short.MAX_VALUE)
                    .add(jPanelDealer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 618, Short.MAX_VALUE)
                    .add(jPanelGameText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelPlayLayout.setVerticalGroup(
            jPanelPlayLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelPlayLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelDealer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 270, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanelPlayer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 270, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jPanelGameText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanelPlayMenu, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        superPanel.add(jPanelPlay, "playCard");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(superPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(superPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    /**
     * Modify GUI with input from model.
     */
    @Override
    public void update(Observable obs, Object obj) {
        if(obj instanceof String) {
            if (((String)obj).contains("Card")) {
                CardLayout card = (CardLayout)superPanel.getLayout();
                card.show(superPanel, (String)obj);
            }
            else if (((String)obj).contains("credits")) {
                jLabelCredits.setText((String)obj);
            }
            else
                jLabelResult.setText((String)obj);
        }
        if(obj instanceof ImageIcon) {
            JLabel cardLabel = new JLabel((ImageIcon)obj);
            jPanelDealer.add(cardLabel);
            jPanelDealer.revalidate();
        }
        if(obj instanceof JLabel) {
            JLabel cardLabel = (JLabel)obj;
            jPanelPlayer.add(cardLabel);
            jPanelPlayer.updateUI();
        }
        if(obj instanceof Integer) {
            switch((Integer)obj) {
                case 1: {
                    jPanelPlayer.removeAll();
                    jPanelDealer.removeAll();
                    jPanelDealer.updateUI();
                    break;
                }
                case 50: {
                    jDialogWinLose.setVisible(true);
                    jButtonHit.setEnabled(false);
                    jButtonStand.setEnabled(false);
                    jButtonMainMenuReturnPlay.setEnabled(true);
                    jButtonChangeBetOpener.setEnabled(true);
                    jButtonNextHand.setEnabled(true);
                    break;
                }
                case 51: {
                    jDialogBetChange.setVisible(true);
                    jButtonHit.setEnabled(false);
                    jButtonStand.setEnabled(false);
                    break;
                }
                case 52: {
                    jDialogLowCredits.setVisible(true);
                    break;
                }
                case 53: {
                    jDialogUser.setVisible(true);
                    break;
                }
                case 54: {
                    jDialogZeroCredits.setVisible(true);
                    jButtonHit.setEnabled(false);
                    jButtonStand.setEnabled(false);
                    jButtonMainMenuReturnPlay.setEnabled(false);
                    jButtonChangeBetOpener.setEnabled(false);
                    jButtonNextHand.setEnabled(false);
                    break;
                }
                case 90: {
                    jDialogWinLose.setVisible(false);
                    jButtonHit.setEnabled(true);
                    jButtonStand.setEnabled(true);
                    break;
                }
                case 91: {
                    jDialogBetChange.setVisible(false);
                    jButtonHit.setEnabled(true);
                    jButtonStand.setEnabled(true);
                    break;
                }
                case 93: {
                    jDialogUser.setVisible(false);
                    break;
                }
                case 94: {
                    jDialogZeroCredits.setVisible(false);
                    jButtonHit.setEnabled(true);
                    jButtonStand.setEnabled(true);
                    break;
                }
                default: {
                    jLabelPlayer.setText("You have: " + (Integer)obj);
                }
            }
        }
        if(obj instanceof Hand) {
            if (((Hand)obj).isDealerFlag())
            {
                jLabelDealer.setText("Dealer has: " + ((Hand)obj).calculateTotal());
            }
            else
                jLabelPlayer.setText("You have: " + ((Hand)obj).calculateTotal());
        }
    }
    
    /**
     * Set up action listeners to interact with controller.
     */
    public void addController(BlackjackControl controller) {
        //System.out.println("View      : adding controller");
        
        jButtonPlay.addActionListener(controller);
        jButtonMainMenuReturnUser.addActionListener(controller);
        jButtonMainMenuReturnPlay.addActionListener(controller);
        jButtonHit.addActionListener(controller);
        jButtonStand.addActionListener(controller);
        jButtonNextHand.addActionListener(controller);
        jButtonChangeBetOpener.addActionListener(controller);
        jButtonBetConfirm.addActionListener(controller);
        jButtonZeroCreditsYes.addActionListener(controller);
        jButtonZeroCreditsNo.addActionListener(controller);
        jTextFieldChooseUser.addActionListener(controller);
    }
    
    private javax.swing.JDialog jDialogWinLose;
    private javax.swing.JDialog jDialogBetChange;
    private javax.swing.JDialog jDialogUser;
    private javax.swing.JDialog jDialogLowCredits;
    private javax.swing.JDialog jDialogZeroCredits;
    private javax.swing.JButton jButtonHit;
    private javax.swing.JButton jButtonStand;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMainMenuReturnUser;
    private javax.swing.JButton jButtonMainMenuReturnPlay;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JButton jButtonChangeBetOpener;
    private javax.swing.JButton jButtonNextHand;
    private javax.swing.JButton jButtonBetConfirm;
    private javax.swing.JButton jButtonLowCredits;
    private javax.swing.JButton jButtonZeroCreditsYes;
    private javax.swing.JButton jButtonZeroCreditsNo;
    private javax.swing.JLabel jLabelEnterName;
    private javax.swing.JLabel jLabelPlayer;
    private javax.swing.JLabel jLabelDealer;
    private javax.swing.JLabel jLabelResult;
    private javax.swing.JLabel jLabelCredits;
    private javax.swing.JLabel jLabelBetSize;
    private javax.swing.JLabel jLabelBetNumber;
    private javax.swing.JLabel jLabelLowCredits;
    private javax.swing.JLabel jLabelZeroCredits;
    private javax.swing.JPanel jPanelPlayMenu;
    private javax.swing.JPanel jPanelMainMenu;
    private javax.swing.JPanel jPanelPlay;
    private javax.swing.JPanel jPanelPlayer;
    private javax.swing.JPanel jPanelDealer;
    private javax.swing.JPanel jPanelGameText;
    private javax.swing.JPanel jPanelUser;
    private javax.swing.JPanel jPanelWinLose;
    private javax.swing.JPanel superPanel;
    private javax.swing.JPanel jPanelBetChange;
    private javax.swing.JPanel jPanelPadTop;
    private javax.swing.JPanel jPanelPadBottom;
    private javax.swing.JPanel jPanelLowCredits;
    private javax.swing.JPanel jPanelZeroCredits;
    private javax.swing.JTextField jTextFieldChooseUser;
    private javax.swing.JSlider jSliderBetChange;
}
