//***********************************************	
//              Filename: TicTacToeSingle.java
//	
//               I hereby declare that this code is a product  of my own efforts. 
//               This coded solution has not been plagiarized from other sources and
//	has not been plagiarized by others.
//
//               This file contains the 3x3 single player class.
//************************************************

package tictactoegui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Justin
 */
public class TicTacToeSingle extends TicTacToeDouble{
    
    Random random_generator = new Random();
    int randomI;
    JFrame frame2;
     
    //Constructor 
    public TicTacToeSingle()
    {
        //Assign new listener to "Instructions" button
        for( ActionListener al : help.getActionListeners() ) {
                help.removeActionListener( al );
                help.addActionListener(new helpListener());
            }
        
        //Assign new listeners to every button on the game board
        for( JButton button: gameArray) 
        {
            for( ActionListener al : button.getActionListeners() ) {
                button.removeActionListener( al );
            }
            
            button.addActionListener(new gameListenerSingle());
         }
  
    }
    
     //Determines which player plays 
    public class gameListenerSingle implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {
            String block = e.getActionCommand();
            JButton button = new JButton();
            button = (JButton)e.getSource();
            boolean gameOn = true;

            //Player 1 turn
            xWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
            oWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
            playerOneSingle(button, block);

             if (isWinner())
             {
                xWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
                oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));

               for (JButton button1: gameArray)
                {
                    button1.setEnabled(false);
                }
             }

            //Player 2 turn
            else 
            {
                oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
                xWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
                playerTwoSingle();

            }
        }
    }
    
     //Function: player one's turn
    public void playerOneSingle(JButton button, String block)
    {
        if (block.equals(" "))
        {
           button.setText("X");
           button.setForeground(Color.RED);
           button.setFont(new Font("Lithos Pro Regular", Font.BOLD, 60));
           gameCounter--;
        }
        
        else
        {
            oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
            xWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
        }
    }
    
    //Function: player two's turn: searches for a random slot on the board. If slot is empty, computer will select it and mark it with "O"
    public void playerTwoSingle()
    {         
         boolean turnOver = false;
             
           do
           {
               randomI = random_generator.nextInt(9);

                   if(gameArray[randomI].getText().equals(" "))
                   {
                       gameArray[randomI].setText("O");
                       gameArray[randomI].setForeground(Color.CYAN);
                       gameArray[randomI].setFont(new Font("Lithos Pro Regular", Font.BOLD, 60));
                       
                       turnOver = true;
                   }
                   
           }while(!turnOver);

           oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
           xWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
           gameCounter--;

           if (isWinner())
           {
               xWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
               oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));

              for (JButton button: gameArray)
                {
                    button.setEnabled(false);
                }
           }
    }
    
   public class helpListener implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {
           JOptionPane.showMessageDialog(null, "How to Play: \n\n1. Human player is X & computer is O \n2. Bolded X or O on the header indicates player's turn\n3. First to 3 in a row wins! \n\n© 2014 jHub", "Instructions", INFORMATION_MESSAGE);
        }
    }
}

