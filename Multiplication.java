//Name: Sol Kim

import java.util.Random;
import java.util.Scanner;

public class Multiplication extends Game {
    private String gameName = "Multiplication";
    private Random rng;
    private int maxNum;
    private int requiredWins;
    private int maxLooses;
    private int x;
    private int y;
    private int userLooses;
    private int userWins;

    /**
     * Constructor of Multiplication.
     * Set variables.
     * @param rng
     * @param maxNum
     * @param requiredWins
     * @param maxLooses
     */
    public Multiplication(Random rng, int maxNum, int requiredWins, int maxLooses) {
        this.rng = rng;
        this.maxNum = maxNum;
        this.requiredWins = requiredWins;
        this.maxLooses = maxLooses;
    }

    /**
     * Select a random x and y for multiplication.
     * Set some variables to pass isOver.
     * @return string
     */
    @Override
    public String prepToPlay() {
        x = rng.nextInt(maxNum - 1) + 1;
        y = rng.nextInt(maxNum - 1) + 1;
        userWins = 0;
        userLooses = 0;
        return (x + " x " + y + " ? Enter the answer. Guess correct answer " + requiredWins +
                " times before I win " + maxLooses + " chances!");
    }

    /**
     * Check whether the game is still ongoing or not.
     * If a user wins as much as required wins or loses as much as allowed, then the game is over.
     * @return bool
     */
    @Override
    public boolean isOver() {
        if ((userLooses == maxLooses) || (userWins == requiredWins)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check whether the user's input is valid or not.
     * Only a number is valid.
     * If the user's input is valid, check whether the input is correct or not.
     * And then, show the result to user.
     * @param move
     * @return bool
     */
    @Override
    public boolean isValid(String move) {
        for (int i = 0; i < move.length(); i++) {
            char x = move.charAt(i);
            if ((x != '0') && (x != '1') && (x != '2') && (x != '3') && (x != '4')
                    && (x != '5') && (x != '6') && (x != '7') && (x != '8') && (x != '9')) {
                return false;
            }
        }

        int input = Integer.parseInt(move);
        if ((x * y) == input) {
            userWins += 1;
            System.out.println("Correct!");
        }
        else {
            userLooses += 1;
            System.out.println("Wrong! The answer is " + (x * y));
        }
        return true;
    }

    /**
     * Select another random x and y.
     * Show a question to user.
     * @param move
     * @return string
     */
    @Override
    public String processMove(String move) {
        //int input = Integer.parseInt(move);
        x = rng.nextInt(maxNum - 1) + 1;
        y = rng.nextInt(maxNum - 1) + 1;
        return (x + " x " + y + " ? ");
    }

    /**
     * Show the result of a set.
     * @return string
     */
    @Override
    public String finalMessage() {
        if (userLooses == maxLooses) {
            return "You lose the set";
        }
        else if (userWins == requiredWins) {
            return "You win the set";
        }
        return "";
    }

    /**
     * Return game name.
     * @return string
     */
    @Override
    public String getName() {
        return gameName;
    }
}