//Name: Sol Kim

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordJumble extends Game{
    private String gameName = "Word jumble";
    private WordsList w1;
    private Random rng;
    private int minWordLen;
    private int maxWordLen;
    private int maxGuesses;
    private String answer;
    private String jumbled;
    private String input;
    private int guessCounter = 0;

    /**
     * Constructor of WordJumble.
     * Set variables.
     * @param w1
     * @param rng
     * @param minWordLen
     * @param maxWordLen
     * @param maxGuesses
     */
    public WordJumble(WordsList w1, Random rng, int minWordLen, int maxWordLen, int maxGuesses){
        this.w1 = w1;
        this.rng = rng;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
    }

    /**
     * Show welcome message and instructions.
     * Choose a random word and jumble it for game.
     * Set some variables to pass isOver.
     * @return string
     */
    @Override
    public String prepToPlay(){
        answer =  w1.getWord(minWordLen, maxWordLen);
        char[] answerArray = answer.toCharArray();

        for (int i = 0; i < answer.length(); i++){
            int x = rng.nextInt(answer.length());
            char temp = answerArray[i];
            answerArray[i] = answerArray[x];
            answerArray[x] = temp;
        }
        jumbled = String.valueOf(answerArray);
        guessCounter = 0;
        input = "";
        return ("The following is a jumbled up word: " + jumbled + " You get " + maxGuesses
                + " guesses to guess it");
    }

    /**
     * Check whether the game is still ongoing or not.
     * If a user used all guesses or guessed a correct answer, then the game is over.
     * @return bool
     */
    @Override
    public boolean isOver(){
        if (guessCounter == maxGuesses){
            return true;
        }
        else if (input.equals(answer)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Check validity of the user's input.
     * Count number of guess.
     * @param move
     * @return bool
     */
    @Override
    public boolean isValid(String move){
        guessCounter += 1;
        input = move;
        return true;
    }

    /**
     * Check whether a user's answer is correct or wrong.
     * @param move
     * @return string (the message is shown only when a user's guess is wrong.)
     */
    @Override
    public String processMove(String move){
        if (move.equals(answer) == false){
            return "That's not it";
        }
        else{
            return null;
        }
    }

    /**
     * Show the answer.
     * @return string
     */
    @Override
    public String finalMessage(){
        return ("The word was " + answer);
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
