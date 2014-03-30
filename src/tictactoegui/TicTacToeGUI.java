//***********************************************	
//              Filename: TicTacToeGUI.java
//	
//               I hereby declare that this code is a product  of my own efforts. 
//               This coded solution has not been plagiarized from other sources and
//	has not been plagiarized by others.
//
//               This file contains the main frame that encapsulates all other game modes using a tabbed pane. 
//               This file also contains the main class.
//************************************************

package tictactoegui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author Justin
 */
public class TicTacToeGUI extends JFrame {
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 650;
    public static JButton restart;
    public static JButton gameMode;
    public static JButton help;
     
    //Constructor
    public TicTacToeGUI()
    {
        super();
        setTitle("Ultimate Tic Tac Toe");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
       
        //Current tab will be highglighted in dark gray
        UIManager.put("TabbedPane.selected", new javax.swing.plaf.ColorUIResource(Color.DARK_GRAY));
        
        //Tabbed pane setup
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.LIGHT_GRAY);
        tabbedPane.setForeground(Color.WHITE);
        
        JPanel threeTab = new JPanel();
        threeTab.setLayout(new CardLayout());
        
        JPanel fourTab = new JPanel();
        fourTab.setLayout(new CardLayout());
        
        JPanel threeTabSingle = new JPanel();
        threeTabSingle.setLayout(new CardLayout());
        
        JPanel fourTabSingle = new JPanel();
        fourTabSingle.setLayout(new CardLayout());
       
        tabbedPane.addTab("3 x 3 Single", threeTabSingle);
        tabbedPane.addTab("3 x 3 Double", threeTab);
        tabbedPane.addTab("4 x 4 Single", fourTabSingle);
        tabbedPane.addTab("4 x 4 Double", fourTab);
        
        JPanel threeByThreeDouble = new TicTacToeDouble();
        JPanel threeByThreeSingle = new TicTacToeSingle();
        JPanel fourByFourDouble = new TicTacToeFourDouble();
        JPanel fourByFourSingle = new TicTacToeFourSingle();
        
        threeTab.add(threeByThreeDouble);
        threeTabSingle.add(threeByThreeSingle);
        fourTab.add(fourByFourDouble);
        fourTabSingle.add(fourByFourSingle);
        //End of tabbed pane setup
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    //Main class
    public static void main(String[] args) {
       
       TicTacToeGUI game = new TicTacToeGUI();
      game.setVisible(true);
      
      JOptionPane.showMessageDialog(null, "Welcome to Ultimate Tic Tac Toe!\n\nYou can play solo or with a friend in: \n- 3x3 Tic Tac Toe \n- 4x4 Tic Tac Toe \n\nEnjoy! \n\n© 2014 jHub", "Welcome to Ultimate Tic Tac Toe!", PLAIN_MESSAGE);
    }
}

