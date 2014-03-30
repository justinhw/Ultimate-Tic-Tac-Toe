//***********************************************	
//              Filename: TicTacToeDouble.java
//	
//               I hereby declare that this code is a product  of my own efforts. 
//               This coded solution has not been plagiarized from other sources and
//	has not been plagiarized by others.
//
//               This file contains the 3x3 two player  class.
//************************************************

package tictactoegui;

/**
 *
 * @author Justin
 */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.SwingConstants;

public class TicTacToeDouble extends JPanel {
    
    private int counter = 0;
    protected int gameCounter = 9;
    protected boolean isWinner = false;
    protected final int WIDTH = 500;
    protected final int HEIGHT = 650;
    protected JLabel xWins;
    protected JLabel oWins;
    protected JLabel xScore;
    protected JLabel ties;
    protected JLabel tieScore;
    protected JLabel oScore;
    protected  JPanel board;
    protected JButton one;
    protected JButton two;
    protected JButton three;
    protected JButton four;
    protected JButton five;
    protected JButton six;
    protected JButton seven;
    protected JButton eight;
    protected JButton nine;
    protected JButton gameArray[] = new JButton[9];
    protected JButton restart;
    protected JButton gameMode;
    protected JButton help;
    protected int xTally = 0;
    protected int oTally = 0;
    protected int tieTally = 0;
    
    //Constructor
    public TicTacToeDouble()
    {
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        
        //Header setup
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(Color.DARK_GRAY);
        
        //First row of header - TITLE 
        JPanel firstRow = new JPanel();
        firstRow.setLayout(new FlowLayout());
        firstRow.setBackground(Color.DARK_GRAY);
        
        JLabel x = new JLabel(" X ");
        x.setForeground(Color.RED);
        x.setFont(new Font("Lithos Pro Regular", Font.BOLD, 20));
        
        JLabel o = new JLabel(" O ");
        o.setForeground(Color.CYAN);
        o.setFont(new Font("Lithos Pro Regular", Font.BOLD, 20));
        
        JLabel title = new JLabel("Tic Tac Toe");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Lithos Pro Regular", Font.BOLD, 20));
        
        firstRow.add(x);
        firstRow.add(title);
        firstRow.add(o);
        
        header.add(firstRow, BorderLayout.NORTH);
        //End of header setup
        
        //Second row of header - STATUS
        JPanel secondRow = new JPanel();
        secondRow.setBackground(Color.DARK_GRAY);
        secondRow.setLayout(new GridLayout(1,3));
        
        xWins = new JLabel(" X ");
        xWins.setBackground(Color.DARK_GRAY);
        xWins.setForeground(Color.RED);
        xWins.setHorizontalAlignment(SwingConstants.CENTER);
        xWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
        
        oWins= new JLabel("O");
        oWins.setBackground(Color.DARK_GRAY);
        oWins.setForeground(Color.CYAN);
        oWins.setHorizontalAlignment(SwingConstants.CENTER);
        oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
        
        ties = new JLabel("Draws");
        ties.setBackground(Color.DARK_GRAY);
        ties.setForeground(Color.WHITE);
        ties.setHorizontalAlignment(SwingConstants.CENTER);
        ties.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
        
        secondRow.add(xWins);
        secondRow.add(ties);
        secondRow.add(oWins);
        
        header.add(secondRow, BorderLayout.CENTER);
        //End of status setup
        
        //Third row of header - WINS
        JPanel thirdRow = new JPanel();
        thirdRow.setBackground(Color.DARK_GRAY);
        thirdRow.setLayout(new GridLayout(1,3));
        
        xScore = new JLabel(" ");
        xScore.setBackground(Color.DARK_GRAY);
        xScore.setForeground(Color.WHITE);
        xScore.setHorizontalAlignment(SwingConstants.CENTER);
        xScore.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
        
        oScore = new JLabel(" ");
        oScore.setBackground(Color.DARK_GRAY);
        oScore.setForeground(Color.WHITE);
        oScore.setHorizontalAlignment(SwingConstants.CENTER);
        oScore.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
        
        tieScore = new JLabel(" ");
        tieScore.setBackground(Color.DARK_GRAY);
        tieScore.setForeground(Color.WHITE);
        tieScore.setHorizontalAlignment(SwingConstants.CENTER);
        tieScore.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
        
        thirdRow.add(xScore);
        thirdRow.add(tieScore);
        thirdRow.add(oScore);
        
        header.add(thirdRow, BorderLayout.SOUTH);
       //End of wins setup
        
        add(header, BorderLayout.NORTH);
        
       //Footer setup
        JPanel footer = new JPanel();
        footer.setLayout(new GridLayout(1,3));
        
        help = new JButton("Instructions");
        help.addActionListener(new helpListener());
        help.setForeground(Color.LIGHT_GRAY);
        help.setBackground(Color.DARK_GRAY);
        help.setBorderPainted(false);
        help.setFocusPainted(false);
        footer.add(help);
        
        restart = new JButton("Play Again!"); 
        restart.addActionListener(new restartListener());
        restart.setBackground(Color.DARK_GRAY);
        restart.setForeground(Color.LIGHT_GRAY);
        restart.setBorderPainted(false);
        restart.setFocusPainted(false);
        footer.add(restart);
        
        gameMode = new JButton("© 2014 jHub");
        gameMode.setEnabled(false);
        gameMode.setBackground(Color.DARK_GRAY);
        gameMode.setBorderPainted(false);
        footer.add(gameMode);
   
        JPanel bottomBar = new JPanel();
        bottomBar.setLayout(new BorderLayout());
        bottomBar.setBackground(Color.DARK_GRAY);
        bottomBar.add(footer, BorderLayout.CENTER);
        //End of footer setup
        
        add(bottomBar, BorderLayout.SOUTH);  
        
        //Setup of game board
        board = new JPanel();
        board.setLayout(new GridLayout(3, 3));
        
        one = new JButton(" ");
        two = new JButton(" ");
        three = new JButton(" ");
        four = new JButton(" ");
        five = new JButton(" ");
        six = new JButton(" ");
        seven = new JButton(" ");
        eight = new JButton(" ");
        nine = new JButton(" ");
        
        gameArray[0] = one;
        gameArray[1] = two;
        gameArray[2] = three;
        gameArray[3] = four;
        gameArray[4] = five;
        gameArray[5] = six;
        gameArray[6] = seven;
        gameArray[7] = eight;
        gameArray[8] = nine;
        
        //Initialize action listeners, background color, disable paint on focus, and add each button to the main board
        for(JButton button : gameArray)
        {
            button.addActionListener(new gameListener());
            button.setBackground(Color.DARK_GRAY);
            button.setFocusPainted(false);
            board.add(button);
        }
        
        add(board, BorderLayout.CENTER);
    }
    
    //Determines which player plays 
    public class gameListener implements ActionListener
    {
            @Override public void actionPerformed(ActionEvent e)
            {
                String block = e.getActionCommand();
                JButton button = new JButton();
                button = (JButton)e.getSource();
                boolean gameOn = true;

                //If counter is even, player 1 turn
                if (counter%2==0)
                {
                    xWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
                    oWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
                    playerOne(e, button, block);
                }

                //If counter is odd, player 2 turn
                else
                {
                    oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
                    xWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
                    playerTwo(e, button, block);
                }

                if (isWinner())
                {
                    xWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
                    oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
                    
                    //Disables all buttons on the gameboard to signifiy end of game
                    for (JButton button1: gameArray)
                     {
                         button1.setEnabled(false);
                     }
                }

                counter++;
        }
    }
    
    
    //Function: player one's turn
    public void playerOne(ActionEvent e, JButton button, String block)
    {
        if (block.equals(" "))
        {
           button.setText("X");
           button.setForeground(Color.RED);
           button.setFont(new Font("Lithos Pro Regular", Font.BOLD, 60));
           gameCounter--;
        }
        
        //If user does not select a valid slot on the board, restart player one's turn and allow them to try again
        else
        {
            oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
            xWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
            counter--;
        }
    }
    
    //Function: player two's turn
    public void playerTwo(ActionEvent e, JButton button, String block)
    {
        if (block.equals(" "))
        {
            button.setText("O");
            button.setForeground(Color.CYAN);
            button.setFont(new Font("Lithos Pro Regular", Font.BOLD, 60));
            gameCounter--;
        }
        
         //If user does not select a valid slot on the board, restart player two's turn and allow them to try again
        else
        {
            xWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
            oWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
            counter--;
        }
    }
    
    //Function: checks if there is a winner
    public boolean  isWinner()
    {
        String winner = "";
        
        //Row win
        if (one.getText().equals(two.getText()) && two.getText().equals(three.getText()) && !one.getText().equals(" "))
        {
            changeColor(one, two, three);
           getWinner((String) one.getText());
           isWinner = true;
        }
        
        //Row win
        else if (four.getText().equals(five.getText()) && five.getText().equals(six.getText()) && !four.getText().equals(" "))
        {
            changeColor(four, five, six);
           getWinner((String)  four.getText());
           isWinner = true;
        }
        
        //Row win
        else if(seven.getText().equals(eight.getText()) && eight.getText().equals(nine.getText()) && !seven.getText().equals(" "))
        {
            changeColor(seven, eight, nine);
            getWinner((String) seven.getText());
           isWinner = true;
        }
        
        //Column win
        else if (one.getText().equals(four.getText()) && four.getText().equals(seven.getText()) && !one.getText().equals(" "))
        {
            changeColor(one, four, seven);
            getWinner((String) one.getText());
            isWinner = true;
        }
        
        //Column win
        else if (two.getText().equals(five.getText()) && five.getText().equals(eight.getText()) && !two.getText().equals(" "))
        {
            changeColor(two, five, eight);
            getWinner((String) two.getText());
            isWinner = true;
        }
        
        //Column win
        else if (three.getText().equals(six.getText()) && six.getText().equals(nine.getText()) && !three.getText().equals(" "))
        {
            changeColor(three, six, nine);
            getWinner((String) three.getText());
            isWinner = true;
        }
        
        //Diagonal win
        else if (seven.getText().equals(five.getText()) && five.getText().equals(three.getText()) && !five.getText().equals(" "))
        {
            changeColor(seven, five, three);
            getWinner((String) seven.getText());
            isWinner = true;
        }
        
        
        //Diagonal win
        else if (nine.getText().equals(five.getText()) && five.getText().equals(one.getText()) && !one.getText().equals(" "))
        {
            changeColor(nine, five, one);
           getWinner((String) one.getText());
           isWinner = true;
        }
        
        //Tie scenario
        else if (gameCounter <= 0)
        {
            getWinner("T");
            isWinner = true;
        }
        
        else
        {
            isWinner = false;
        }
        
        return isWinner;
    }
    
    //Function: Changes background color of block to another color:
    public void changeColor(JButton button1, JButton button2, JButton button3)
    {
        button1.setBackground(Color.LIGHT_GRAY);
        button2.setBackground(Color.LIGHT_GRAY);
        button3.setBackground(Color.LIGHT_GRAY);
    }
    
    //Function: checks and returns whether winner is "X" or "O"
    public void  getWinner(String winnerAvatar)
    {
        if (winnerAvatar.equals("X"))
        {
            xTally++;
            String xTallyString = Integer.toString(xTally);
            xScore.setText( xTallyString);
        }
        
        else if (winnerAvatar.equals("T"))
        {
            tieTally++;
            String tieTallyString = Integer.toString(tieTally);
            tieScore.setText( tieTallyString);
        }
        
        else if (winnerAvatar.equals("O"))
        {
            oTally++;
            String oTallyString = Integer.toString(oTally);
            oScore.setText( oTallyString);
        }
    }
    
    //If "Play Again" button is clicked, game is reset
    public class restartListener implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {
            
            for (JButton button : gameArray)
            {
                button.setText(" ");
                button.setEnabled(true);
                button.setBackground(Color.DARK_GRAY);
            }
            
            oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
            xWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
            
            gameCounter = 9;
            counter = 0;
        }
    }
   
    //If "Instructions" button is clicked, instructions to play that specific game is displayed to the user
     public class helpListener implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {
           JOptionPane.showMessageDialog(null, "How to Play: \n\n1. Player 1 is X & Player 2 is O \n2. Bolded X or O on the header indicates player's turn\n3. First to 3 in a row wins!", "Instructions", INFORMATION_MESSAGE);
        }
    }
}
