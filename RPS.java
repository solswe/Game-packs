//Name: Sol Kim

import java.util.Random;
import java.util.Scanner;

public class RPS extends Game{
    private String gameName = "Rock Paper Scissors";
    private Random rng;
    private int requiredWins;
    private int maxLooses;
    private int userLooses;
    private int userWins;

    /**
     * Constructor of RPS.
     * Set variables.
     * @param rng
     * @param requiredWins
     * @param maxLooses
     */
    public RPS(Random rng, int requiredWins, int maxLooses){
        this.rng = rng;
        this.requiredWins = requiredWins;
        this.maxLooses = maxLooses;
    }

    /**
     * Show welcome message and instructions.
     * Set some variables to pass isOver.
     * @return string
     */
    @Override
    public String prepToPlay(){
        userWins = 0;
        userLooses = 0;
        return "Enter rock, paper, or scissors. Beat me " + requiredWins +
                " times before I win " + maxLooses + " times!";
    }

    /**
     * Check whether the game is still ongoing or not.
     * If a user wins as much as required wins or loses as much as allowed, then the game is over.
     * @return bool
     */
    @Override
    public boolean isOver(){
        if ((userLooses == maxLooses) || (userWins == requiredWins)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Check validity of the user's input.
     * @param move
     * @return bool
     */
    @Override
    public boolean isValid(String move){
        if ((move.equals("rock")) || (move.equals("paper")) || (move.equals("scissors"))){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Pick a computer's move.
     * Compare user's move to computer's move, and find out who wins.
     * @param move
     * @return string showing that if a user wins, loses, or ties.
     */
    @Override
    public String processMove(String move){

        String[] rps = {"rock", "paper", "scissors"};
        int x = rng.nextInt(rps.length);
        String aiPick = rps[x];
        System.out.print(aiPick + " vs. " + move + " ");

        if (aiPick.equals(move)){
            return "We Tie";
        }

        if (x == 0){
            if (move.equals("paper")){
                userWins += 1;
                return "you Win";
            }
            else{
                userLooses += 1;
                return "you Lose";
            }
        }
        else if (x == 1){
            if (move.equals("rock")){
                userLooses += 1;
                return "you Lose";
            }
            else{
                userWins += 1;
                return "you Win";
            }
        }
        else {
            if (move.equals("rock")){
                userWins += 1;
                return "you Win";
            }
            else{
                userLooses += 1;
                return "you lose";
            }
        }
    }

    /**
     * Show the result of a set.
     * @return string.
     */
    @Override
    public String finalMessage(){
        if (userLooses == maxLooses){
            return "You lose the set";
        }
        else if (userWins == requiredWins){
            return "You win the set";
        }
        else {
            return "You quit the set.";
        }
    }

    /**
     * Return game name.
     * @return string
     */
    @Override
    public String getName(){
        return gameName;
    }
}

