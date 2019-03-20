package rockPaperScissors; // this programme is saved inside a package.

import java.util.Random;
import java.util.Scanner;

public class rockPaperSissors { // The name of the class is rockPaperSissors and the below body is within this class.

    String playerName; // this is where the game starts and the programme will ask for the players name.
    String playerMove; // this is asking the players move, i.e. rock, paper or scissors.
    String computerMove; // this initiates the computer to make its move.
    int score;
    Scanner myScanner = new Scanner(System.in); // this Scanner is a type of variable and its calling in a new Scanner variable.

    public static void main(String[] args) { // this is the method. This is when the programme starts running/executing the game.
        rockPaperSissors rps = new rockPaperSissors(); // calling for a new new game.
        rps.initialiseGame();
    }


    private void initialiseGame() { // here the programme is initialising the game to print out the text of Enter your name.
        System.out.println("Enter your name: "); // this is a statement. this is the part where it actually prints out the Enter your name: text.
        playerName = myScanner.nextLine(); // will print out the players name. here its put the data on the next line.
        playGame(); // this now will play the game.
    }

    private void playGame() { // a method.
        System.out.println("Enter your move: "); // this will print out on the screen text saying Enter your move:.
        playerMove = myScanner.nextLine(); // the player
        System.out.println(playerName + " has selected " + playerMove + " as their move");
        computerMove = generateComputerMove();
        String result = getWinner(playerMove, computerMove);
        if (result.equalsIgnoreCase("Win")) {
            System.out.println("Congratulations, you won this round!");
            score++;
        } else if (result.equalsIgnoreCase("Lose")) {
            System.out.println("You lost this round!");
            score--;
        } else {
            System.out.println("This round was a draw!");
        }

        if (score < 3 && score > -3) {
            playGame();
        } else if (score == 3) {
            System.out.println("Winner Winner!!");
        } else if (score == -3) {
            System.out.println("You Looooooosssseeeee!");
        }

    }

    private String generateComputerMove() {
        Random r = new Random();
        String move = "";
        int i = r.nextInt(3);
        switch (i) {
            case 0:
                move = "Rock";
                break;

            case 1:
                move = "Paper";
                break;

            case 2:
                move = "Scissors";
                break;
        }
        return move;
    }

    private String getWinner(String playerMove, String computerMove) {
        String outcome = "";
        if (playerMove.equalsIgnoreCase("rock")) {
            if (computerMove.equalsIgnoreCase("rock")) {
                outcome = "Draw";
            } else if (computerMove.equalsIgnoreCase("paper")) {
                outcome = "Lose";
            } else {
                outcome = "Win";
            }
        }
        if (playerMove.equalsIgnoreCase("paper")) {
            if (computerMove.equalsIgnoreCase("rock")) {
                outcome = "Win";
            } else if (computerMove.equalsIgnoreCase("paper")) {
                outcome = "Draw";
            } else {
                outcome = "Lose";
            }
        }
        if (playerMove.equalsIgnoreCase("scissors")) {
            if (computerMove.equalsIgnoreCase("rock")) {
                outcome = "Lose";
            } else if (computerMove.equalsIgnoreCase("paper")) {
                outcome = "Win";
            } else {
                outcome = "Draw";
            }
        }
        return outcome;
    }
}
