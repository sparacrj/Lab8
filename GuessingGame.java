import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {

 JTextField userGuess;
 JButton buttonGuess;
 JButton buttonPlayAgain;
 JLabel lblPrompt;
 JLabel lblGuess;
 JLabel lblPlayAgain;

 Random r = new Random();
  int randomNum = r.nextInt(100)+1;

 GuessingGame(){

JFrame frame = new JFrame("Guessing Game");
frame.setLayout(new FlowLayout());
frame.setSize(240,140);

userGuess = new JTextField(10);
userGuess.setActionCommand("myTF");

buttonGuess = new JButton("Guess");
buttonPlayAgain = new JButton("Play Again");

userGuess.addActionListener(this);
buttonGuess.addActionListener(this);
buttonPlayAgain.addActionListener(this);

lblPrompt = new JLabel("Enter your guess: ");
lblGuess = new JLabel("");
lblPlayAgain = new JLabel("");

frame.add(lblPrompt);
frame.add(userGuess);
frame.add(buttonGuess);
frame.add(lblGuess);
frame.add(lblPlayAgain);
frame.add(buttonPlayAgain);

frame.setVisible(true);
 }

 public void actionPerformed(ActionEvent ae) {
   if(ae.getActionCommand().equals("Guess")) {
     
     int guess = Integer.parseInt(userGuess.getText());
     
     if(guess < randomNum){
       lblPrompt.setText("Too Low!");
     }
    
    else if (guess > randomNum) {
      lblPrompt.setText("Too High");
    }

    else{
      lblPrompt.setText("You Got It!");
    }
    
    lblGuess.setText("Last guess was " + guess);
    userGuess.setText("");
     }

    else if(ae.getActionCommand().equals("Play Again")){
      int randomNum2 = r.nextInt(100)+1;
      randomNum = randomNum2;
      lblPrompt.setText("Enter your guess: ");
      lblGuess.setText("");
      lblPlayAgain.setText("");
      userGuess.setText("");
    }
    else{
      lblGuess.setText("You pressed Enter. Please press the Guess Button.");
    }
    
   }
 }