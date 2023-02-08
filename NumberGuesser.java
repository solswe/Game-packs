//Name: Sol Kim

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser extends Game{
    private String gameName = "NumberGuesser";
    private Random rng;
    private int maxNumber;
    private int maxGuesses;
    private int answer;
    private int guessCounter;
    private int input;

    /**
     * Constructor of NumberGuesser.
     * Set variables.
     * @param rng
     * @param maxNumber
     * @param maxGuesses
     */
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses){
        this.rng = rng;
        this.maxNumber = maxNumber;
        this.maxGuesses = maxGuesses;
    }

    /**
     * Show welcome message and instructions.
     * Choose a random number for game.
     * Set some variables to pass isOver.
     * @return string
     */
    @Override
    public String prepToPlay(){
        answer = rng.nextInt(maxNumber) + 1;
        guessCounter = 0;
        input = 0;
        return ("I've picked a number 1 to " + maxNumber + ". You get " + maxGuesses + " guesses to guess it");
    }

    /**
     * Check whether a game is over or not.
     * If user used all guesses or guessed the correct answer, the game is over.
     * @return bool
     */
    @Override
    public boolean isOver(){
        if (guessCounter == maxGuesses){
            return true;
        }
        else if (input == answer){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Check if the user's input is valid.
     * Count a guess.
     * @param move
     * @return bool
     */
    @Override
    public boolean isValid(String move){
        for (int i = 0; i < move.length(); i++){
            char x = move.charAt(i);
            if ((x != '0') && (x != '1') && (x != '2') && (x != '3') && (x != '4')
                    && (x != '5') && (x != '6') && (x != '7') && (x != '8') && (x != '9')){
                return false;
            }
        }
        guessCounter += 1;
        return true;
    }

    /**
     * Compare the user's guess to answer.
     * Let the user know whether his guess is higher or lower or correct.
     * @param move
     * @return
     */
    @Override
    public String processMove(String move){
        //guessCounter += 1;
        //System.out.println(guessCounter);
        input = Integer.parseInt(move);
        if (input > answer){
            return "Too High";
        }
        else if (input < answer){
            return "Too Low";
        }
        else{
            return "That's it!";
        }
    }

    /**
     * Show the answer.
     * @return string
     */
    @Override
    public String finalMessage(){
        return ("The number was: " + answer);
    }

    /**
     * Return the game name.
     * @return string
     */
    @Override
    public String getName(){
        return gameName;
    }
}
