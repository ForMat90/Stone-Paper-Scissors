package com.play.stonepaperscissors.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StonePaperScissorsController {

    private static final String PAPER = "paper";
    private static final String STONE = "stone";
    private static final String SCISSORS = "scissors";
    private Image image;
    @FXML
    private Label resultLabel;
    @FXML
    private Button stoneButton;
    @FXML
    private Button paperButton;
    @FXML
    private Button scissorsButton;

    @FXML
    private Label playerScore;

    @FXML
    private Label computerScore;

    @FXML
    private ImageView player;
    @FXML
    private ImageView computer;

    @FXML
    private void playerTurn(ActionEvent event) {
        try {
            String playerChoice = null;
            switch (((Button) event.getSource()).getId()) {
                case "paperButton":
                    image = new Image("D:/Progetti/StonePaperScissors/src/main/resources/img/paper.png");
                    playerChoice = PAPER;
                    break;
                case "stoneButton":
                    image = new Image("D:/Progetti/StonePaperScissors/src/main/resources/img/stone.png");
                    playerChoice = STONE;
                    break;
                case "scissorsButton":
                    image = new Image("D:/Progetti/StonePaperScissors/src/main/resources/img/scissors.png");
                    playerChoice = SCISSORS;
                    break;
            }
            player.setImage(image);

            winner(playerChoice, computerTurn());
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }

    private String computerTurn() {
        String computerChoice = null;
        int index = (int) (Math.random() * 3);
        switch (index) {
            case 0:
                image = new Image("D:/Progetti/StonePaperScissors/src/main/resources/img/stone.png");
                computerChoice = STONE;
                break;
            case 1:
                image = new Image("D:/Progetti/StonePaperScissors/src/main/resources/img/paper.png");
                computerChoice = PAPER;
                break;
            case 2:
                image = new Image("D:/Progetti/StonePaperScissors/src/main/resources/img/scissors.png");
                computerChoice = SCISSORS;
                break;
        }
        computer.setImage(image);
        return computerChoice;
    }

    public void playerWin() {
        resultLabel.setText("Hai vinto!");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
    }

    public void computerWin() {
        resultLabel.setText("Hai perso!");
        computerScore.setText(String.valueOf(Integer.parseInt(computerScore.getText()) + 1));
    }

    public void draw() {
        resultLabel.setText("Pareggio!");
    }

    private void winner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            draw();
            return;
        }
        if (playerChoice.equals(STONE)) {
            if (computerChoice.equals(PAPER)) {
                computerWin();
            } else if (computerChoice.equals(SCISSORS)) {
                playerWin();
            }
        } else if (playerChoice.equals(PAPER)) {
            if (computerChoice.equals(STONE)) {
                playerWin();
            } else if (computerChoice.equals(SCISSORS)) {
                computerWin();
            }
        } else {
            if (computerChoice.equals(STONE)) {
                computerWin();
            } else if (computerChoice.equals(PAPER)) {
                playerWin();
            }
        }
    }
}

