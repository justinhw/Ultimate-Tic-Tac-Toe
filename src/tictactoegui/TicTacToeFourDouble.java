//***********************************************	
//              Filename: TicTacToeFourDouble.java
//	
//               I hereby declare that this code is a product  of my own efforts. 
//               This coded solution has not been plagiarized from other sources and
//	has not been plagiarized by others.
//
//               This file contains the 4x4 two player  class.
//************************************************

package tictactoegui;

/**
 *
 * @author Justin
 */
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToeFourDouble extends TicTacToeDouble{
    
    protected int counter = 0;
    protected int gameCounter = 16;
    protected  JButton ten;
    protected  JButton eleven;
    protected  JButton twelve;
    protected  JButton thirteen;
    protected  JButton fourteen;
    protected JButton fifteen;
    protected JButton sixteen;

    protected JButton gameArray[] = new JButton[16];
    
    //Constructor
    public TicTacToeFourDouble()
    {
        super();
        board = new JPanel();
        board.setLayout(new GridLayout(4, 4));        
        
        //Setup new board with 16 slots
        one = new JButton(" ");
        two = new JButton(" ");
        three = new JButton(" ");
        four = new JButton(" ");
        five = new JButton(" ");
        six = new JButton(" ");
        seven = new JButton(" ");
        eight = new JButton(" ");
        nine = new JButton(" ");
        ten = new JButton(" ");
        eleven = new JButton(" ");
        twelve = new JButton(" ");
        thirteen = new JButton(" ");
        fourteen = new JButton(" ");
        fifteen = new JButton(" ");
        sixteen = new JButton(" ");
        
        gameArray[0] = one;
        gameArray[1] = two;
        gameArray[2] = three;
        gameArray[3] = four;
        gameArray[4] = five;
        gameArray[5] = six;
        gameArray[6] = seven;
        gameArray[7] = eight;
        gameArray[8] = nine;
        gameArray[9] = ten;
        gameArray[10] = eleven;
        gameArray[11] = twelve;
        gameArray[12] = thirteen;
        gameArray[13] = fourteen;
        gameArray[14] = fifteen;
        gameArray[15] = sixteen;
        
        //Assign new action listeners and rules to 16 buttons
        for (JButton button : gameArray)
        {
            button.addActionListener(new gameListener());
            button.setBackground(Color.DARK_GRAY);
            button.setFocusPainted(false);
            board.add(button);
        }
        
        //Remove old action listeners and add new action listeners to "Instructions" button
         for( ActionListener al : restart.getActionListeners() ) {
                restart.removeActionListener( al );
                restart.addActionListener(new restartListener());
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

               for (JButton jbutton : gameArray)
               {
                   jbutton.setEnabled(false);
               }
            }

            counter++;
        }
    }
    //Function: checks if there is a winner
    @Override public boolean  isWinner()
    {
        String winner = "";
        
        //Horizontal wins
        if (two.getText().equals(three.getText()) && (one.getText().equals(two.getText()) || four.getText().equals(three.getText())) && !two.getText().equals(" "))
        {
           changeColor(one, two, three, four);
           getWinner((String) two.getText());
           isWinner = true;
        }
        
        else if (six.getText().equals(seven.getText()) &&( five.getText().equals(six.getText()) || (eight.getText().equals(seven.getText()))) && !seven.getText().equals(" "))
        {
            changeColor(five, six, seven, eight);
           getWinner((String)  six.getText());
           isWinner = true;
        }
        
        else if (ten.getText().equals(eleven.getText()) && (nine.getText().equals(ten.getText()) || (eleven.getText().equals(twelve.getText()))) && !ten.getText().equals(" "))
        {
            changeColor(nine, ten, eleven, twelve);
            getWinner((String) ten.getText());
           isWinner = true;
        }
        
        else if (fourteen.getText().equals(fifteen.getText()) && (thirteen.getText().equals(fourteen.getText()) || fifteen.getText().equals(sixteen.getText())) && !fourteen.getText().equals(" "))
        {
            changeColor(thirteen, fourteen, fifteen, sixteen);
            getWinner((String) fourteen.getText());
            isWinner = true;
        }
        
        //Vertical wins
        else if (five.getText().equals(nine.getText()) && (one.getText().equals(five.getText()) || nine.getText().equals(thirteen.getText())) && !five.getText().equals(" "))
        {
            changeColor(one, five, nine, thirteen);
            getWinner((String) five.getText());
            isWinner = true;
        }
        
        else if (ten.getText().equals(six.getText()) && (two.getText().equals(six.getText()) || ten.getText().equals(fourteen.getText())) && !six.getText().equals(" "))
        {
            changeColor(two, six, ten, fourteen);
            getWinner((String) six.getText());
            isWinner = true;
        }
        
        else if (seven.getText().equals(eleven.getText()) && (three.getText().equals(seven.getText()) || eleven.getText().equals(fifteen.getText())) && !seven.getText().equals(" "))
        {
            changeColor(three, seven, eleven, fifteen);
            getWinner((String) seven.getText());
            isWinner = true;
        }
        
        else if ((eight.getText().equals(twelve.getText()) && (four.getText().equals(eight.getText()) || twelve.getText().equals(sixteen.getText())) && !eight.getText().equals(" ")))
        {
            changeColor(four, eight, twelve, sixteen);
           getWinner((String) eight.getText());
           isWinner = true;
        }
        
        //Diagonal wins
        else if ((ten.getText().equals(seven.getText()) && (thirteen.getText().equals(ten.getText()) || seven.getText().equals(four.getText())) && !ten.getText().equals(" ")))
        {
            changeColor(thirteen, ten, seven, four);
           getWinner((String) ten.getText());
           isWinner = true;
        }
        
        else if ((six.getText().equals(eleven.getText()) && (one.getText().equals(six.getText()) || eleven.getText().equals(sixteen.getText())) && !eleven.getText().equals(" ")))
        {
            changeColor(one, six, eleven, sixteen);
           getWinner((String) eleven.getText());
           isWinner = true;
        }
        
        else if (nine.getText().equals(six.getText()) && six.getText().equals(three.getText()) && !six.getText().equals(" "))
        {
            changeColor(nine, six, three);
            getWinner((String) seven.getText());
            isWinner = true;
        }
        
        else if (fourteen.getText().equals(eleven.getText()) && eleven.getText().equals(eight.getText()) && !eleven.getText().equals(" "))
        {
            changeColor(fourteen, eleven, eight);
            getWinner((String) eleven.getText());
            isWinner = true;
        }
        
        else if (five.getText().equals(ten.getText()) && ten.getText().equals(fifteen.getText()) && !ten.getText().equals(" "))
        {
            changeColor(five, ten, fifteen);
            getWinner((String) seven.getText());
            isWinner = true;
        }
        
        else if (two.getText().equals(seven.getText()) && seven.getText().equals(twelve.getText()) && !seven.getText().equals(" "))
        {
            changeColor(seven, five, three);
            getWinner((String) seven.getText());
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
    public void changeColor(JButton button1, JButton button2, JButton button3, JButton button4)
    {
        JButton array[] = new JButton[4];
        array[0] = button1;
        array[1] = button2;
        array[2] = button3;
        array[3] = button4;
        
        for (int i=0; i<4; i++)
        {
            if (i==3 && array[i].getText().equals(array[0].getText()))
            {
                array[i].setBackground(Color.LIGHT_GRAY);
            }
            
            else if (i==3)
            {
                break;
            }
            
            else if (array[i].getText().equals(array[i+1].getText()))
            {
                    array[i].setBackground(Color.LIGHT_GRAY);
                    array[i+1].setBackground(Color.LIGHT_GRAY);
           }
        }
    }
   
    //Restart listener restarts all 16 buttons
   public class restartListener implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent e)
        {   
            for (JButton button: gameArray)
            {
                button.setText(" ");
                button.setEnabled(true);
                button.setBackground(Color.DARK_GRAY);
            }
            
            oWins.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 15));
            xWins.setFont(new Font("Lithos Pro Regular", Font.BOLD, 25));
            
            gameCounter = 16;
            counter = 0;
        }
    }
}

