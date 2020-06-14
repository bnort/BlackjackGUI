/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgui;


import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/**
 *
 * @author bnort
 */
public class BlackjackView extends javax.swing.JFrame implements Observer  {
    
    public BlackjackView() {
        initComponents();
    }
    
    private void initComponents() {

        superPanel = new javax.swing.JPanel();
        jPanelMainMenu = new javax.swing.JPanel();
        jButtonPlay = new javax.swing.JButton();
        jButtonUser = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jPanelUser = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButtonMainMenuReturnUser = new javax.swing.JButton();
        jButtonMainMenuReturnPlay = new javax.swing.JButton();
        jPanelPlay = new javax.swing.JPanel();
        jButtonHit = new javax.swing.JButton();
        jButtonStand = new javax.swing.JButton();
        jPanelPlayMenu = new javax.swing.JPanel();
        jPanelPlayer = new javax.swing.JPanel();
        jPanelDealer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(208, 208, 208));

        superPanel.setLayout(new java.awt.CardLayout());

        jButtonPlay.setBackground(new java.awt.Color(11, 211, 211));
        jButtonPlay.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButtonPlay.setForeground(new java.awt.Color(248, 144, 231));
        jButtonPlay.setText("Play");
        jButtonPlay.setDefaultCapable(false);

        jButtonUser.setBackground(new java.awt.Color(11, 211, 211));
        jButtonUser.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButtonUser.setForeground(new java.awt.Color(248, 144, 231));
        jButtonUser.setText("Choose User");

        jButtonExit.setBackground(new java.awt.Color(11, 211, 211));
        jButtonExit.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(248, 144, 231));
        jButtonExit.setText("Exit");

        org.jdesktop.layout.GroupLayout jPanelMainMenuLayout = new org.jdesktop.layout.GroupLayout(jPanelMainMenu);
        jPanelMainMenu.setLayout(jPanelMainMenuLayout);
        jPanelMainMenuLayout.setHorizontalGroup(
            jPanelMainMenuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelMainMenuLayout.createSequentialGroup()
                .add(85, 85, 85)
                .add(jPanelMainMenuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButtonExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonPlay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(403, Short.MAX_VALUE))
        );
        jPanelMainMenuLayout.setVerticalGroup(
            jPanelMainMenuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelMainMenuLayout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .add(jButtonPlay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButtonUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButtonExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(93, 93, 93))
        );

        superPanel.add(jPanelMainMenu, "mainMenuCard");

        jLabel3.setText("Please enter your name:");

        jButtonMainMenuReturnUser.setText("Main Menu");
        jButtonMainMenuReturnUser.setToolTipText("");

        org.jdesktop.layout.GroupLayout jPanelUserLayout = new org.jdesktop.layout.GroupLayout(jPanelUser);
        jPanelUser.setLayout(jPanelUserLayout);
        jPanelUserLayout.setHorizontalGroup(
            jPanelUserLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelUserLayout.createSequentialGroup()
                .add(277, 277, 277)
                .add(jPanelUserLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(220, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelUserLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButtonMainMenuReturnUser)
                .addContainerGap())
        );
        jPanelUserLayout.setVerticalGroup(
            jPanelUserLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelUserLayout.createSequentialGroup()
                .add(208, 208, 208)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 543, Short.MAX_VALUE)
                .add(jButtonMainMenuReturnUser)
                .addContainerGap())
        );

        superPanel.add(jPanelUser, "userCard");

        jButtonHit.setText("Hit");

        jButtonStand.setText("Stand");
        
        jButtonMainMenuReturnPlay.setText("Main Menu");
        jButtonMainMenuReturnPlay.setToolTipText("");

        org.jdesktop.layout.GroupLayout jPanelPlayMenuLayout = new org.jdesktop.layout.GroupLayout(jPanelPlayMenu);
        jPanelPlayMenu.setLayout(jPanelPlayMenuLayout);
        jPanelPlayMenuLayout.setHorizontalGroup(
            jPanelPlayMenuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelPlayMenuLayout.createSequentialGroup()
                .add(57, 57, 57)
                .add(jButtonHit)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 144, Short.MAX_VALUE)
                .add(jButtonStand)
                .add(138, 138, 138)
                .add(jButtonMainMenuReturnPlay))
        );
        jPanelPlayMenuLayout.setVerticalGroup(
            jPanelPlayMenuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelPlayMenuLayout.createSequentialGroup()
                .add(0, 69, Short.MAX_VALUE)
                .add(jPanelPlayMenuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonHit)
                    .add(jButtonStand)
                    .add(jButtonMainMenuReturnPlay))
                .add(41, 41, 41))
        );

        org.jdesktop.layout.GroupLayout jPanelPlayLayout = new org.jdesktop.layout.GroupLayout(jPanelPlay);
        jPanelPlay.setLayout(jPanelPlayLayout);
        jPanelPlayLayout.setHorizontalGroup(
            jPanelPlayLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelPlayLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelPlayLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelPlayMenu, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanelPlayer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 618, Short.MAX_VALUE)
                    .add(jPanelDealer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 618, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelPlayLayout.setVerticalGroup(
            jPanelPlayLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelPlayLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelDealer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanelPlayer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanelPlayMenu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }
    
    @Override
    public void update(Observable obs, Object obj) {
        if(obj instanceof String) {
            CardLayout card = (CardLayout)superPanel.getLayout();
            card.show(superPanel, (String)obj);
        }
        //TODO: MAKE THIS SHIT GOOD
        if(obj instanceof ImageIcon) {
            JLabel cardLabel = new JLabel((ImageIcon)obj);
            jPanelDealer.add(cardLabel);
            jPanelDealer.updateUI();
        }
        if(obj instanceof JLabel) {
            JLabel cardLabel = (JLabel)obj;
            jPanelPlayer.add(cardLabel);
            jPanelPlayer.updateUI();
        }
        if(obj instanceof Integer) {
            jPanelPlayer.removeAll();
            jPanelDealer.removeAll();
        }
    }

    public void addController(BlackjackControl controller) {
        System.out.println("View      : adding controller");
        
        jButtonPlay.addActionListener(controller);
        jButtonUser.addActionListener(controller);
        jButtonExit.addActionListener(controller);
        jButtonMainMenuReturnUser.addActionListener(controller);
        jButtonMainMenuReturnPlay.addActionListener(controller);
        jButtonHit.addActionListener(controller);
        jButtonStand.addActionListener(controller);
    }
    
    private javax.swing.JButton jButtonHit;
    private javax.swing.JButton jButtonStand;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMainMenuReturnUser;
    private javax.swing.JButton jButtonMainMenuReturnPlay;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelPlayMenu;
    private javax.swing.JPanel jPanelMainMenu;
    private javax.swing.JPanel jPanelPlay;
    private javax.swing.JPanel jPanelPlayer;
    private javax.swing.JPanel jPanelDealer;
    private javax.swing.JPanel jPanelUser;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel superPanel;
}
