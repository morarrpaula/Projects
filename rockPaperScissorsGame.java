package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rockPaperScissorsGame {

    private JFrame frame;
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JLabel resultLabel;
    private JLabel scoreLabel;
    private JLabel playerScoreLabel;
    private JLabel computerScoreLabel;
    private int playerScore;
    private int computerScore;

    public rockPaperScissorsGame() {
        frame = new JFrame("Rock, Paper, Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        playerScore = 0;
        computerScore = 0;

        int imageWidth = 100;
        int imageHeight = 100;


        rockButton = new JButton(new ImageIcon(new ImageIcon("C:\\Users\\Paula\\Desktop\\piatra-seiryu-l-45-55-kg.jpg").getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
        paperButton = new JButton(new ImageIcon(new ImageIcon("C:\\Users\\Paula\\Desktop\\hartie-pentru-desen-50x70-cm-120-gr.jpg").getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
        scissorsButton = new JButton(new ImageIcon(new ImageIcon("C:\\Users\\Paula\\Desktop\\foarfece-kangaro---el-73--185-cm--manere-portocalii-30.jpg").getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
        resultLabel = new JLabel("Make your choice!");
        scoreLabel = new JLabel("Score: Player 0 - 0 Computer");
        playerScoreLabel = new JLabel("Player Points: 0 ");
        computerScoreLabel = new JLabel("Computer Points: 0");

        rockButton.addActionListener(new ChoiceListener("Rock"));
        paperButton.addActionListener(new ChoiceListener("Paper"));
        scissorsButton.addActionListener(new ChoiceListener("Scissors"));


        frame.add(rockButton);
        frame.add(paperButton);
        frame.add(scissorsButton);
        frame.add(resultLabel);
        frame.add(scoreLabel);
        frame.add(playerScoreLabel);
        frame.add(computerScoreLabel);

        frame.setVisible(true);

    }

    private class ChoiceListener implements ActionListener {
        private String playerChoice;

        public ChoiceListener(String playerChoice) {
            this.playerChoice = playerChoice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] choices = {"Rock", "Paper", "Scissors"};
            String computerChoice = choices[(int) (Math.random() * 3)];

            if (playerChoice.equals(computerChoice)) {
                resultLabel.setText("It's a tie! Both chose " + playerChoice);
            } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                    (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                    (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
                resultLabel.setText("You win! " + playerChoice + " beats " + computerChoice);
                playerScore++;
            } else {
                resultLabel.setText("Computer wins! " + computerChoice + " beats " + playerChoice);
                computerScore++;
            }
            scoreLabel.setText("Score: Player " + playerScore + " - " + computerScore + " Computer ");
            playerScoreLabel.setText("Player Points: " + playerScore);
            computerScoreLabel.setText("Computer Points "+ computerScore);

            if(playerScore == 5) {
                JOptionPane.showMessageDialog(frame, "Congratulations! You reached 5 points first!");
                resetGame();
            }else if(computerScore == 5){
                JOptionPane.showMessageDialog(frame, "Computer reached 5 points first! Better luck next time.");
                resetGame();
            }
        }
    }

    private void resetGame(){
        playerScore = 0 ;
        computerScore = 0;
        scoreLabel.setText("Score: Player 0 - 0 Computer");
        playerScoreLabel.setText("Player Points: 0");
        computerScoreLabel.setText("Computer Points: 0");
        resultLabel.setText("Make your choice!");
    }

    public static void main(String[] args) {
        
        new rockPaperScissorsGame();
    }
}
