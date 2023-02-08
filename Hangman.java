//Name: Sol Kim

import java.util.Random;
import java.util.Scanner;

public class Hangman extends Game{
    private String gameName = "Hangman";
    private String answerWord;
    private WordsList words;
    private int minWordLen;
    private int maxWordLen;
    private int maxGuesses;
    private int guessCounter = 0;
    private String hint = "";

    /**
     * Constructor of Hangman.
     * Set variables.
     * @param words
     * @param minWordLen
     * @param maxWordLen
     * @param maxGuesses
     */
    public Hangman (WordsList words, int minWordLen, int maxWordLen, int maxGuesses){
        this.words = words;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
    }

    /**
     * Show welcome message and instructions.
     * Set some variables to pass isOver.
     * @return string
     */
    @Override
    public String prepToPlay(){
        answerWord = words.getWord(this.minWordLen, this.maxWordLen);
        guessCounter = 0;
        hint = "";
        for (int i = 0; i < answerWord.length(); i++){
            hint += "_";
        }
        return ("I've picked a " + answerWord.length() + " letter word. Guess letters you think are in the word. " +
                "You get " + maxGuesses + " guesses.");
    }

    /**
     * Check whether the game is still ongoing or not.
     * @return bool (true means the game is over, and false means the game is ongoing.)
     */
    @Override
    public boolean isOver(){
        if (guessCounter == maxGuesses){
            return true;
        }
        else if (hint.equals(answerWord)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Check validity of the user's input.
     * @param move
     * @return bool (true means it's valid, and false means it's invalid.)
     */
    @Override
    public boolean isValid(String move){
        guessCounter += 1;
        //System.out.println(guessCounter);
        char x = move.charAt(0);

        if ((move.length() == 1) && (Character.isLetter(x))){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Check if the user's input is correct, and update that to the hint.
     * @param move
     * @return string (correctly guessed letters will be shown as letter itself, and others will be shown as "_")
     */
    @Override
    public String processMove(String move){
        char x = move.charAt(0);
        char[] hintArray = hint.toCharArray();
        for (int i = 0; i < answerWord.length(); i++) {
            if (answerWord.charAt(i) == x) {
                hintArray[i] = x;
            }
        }
        hint = String.valueOf(hintArray);
        return hint;
    }

    /**
     * Show the answer.
     * @return string
     */
    @Override
    public String finalMessage(){
        return ("The word was: " + answerWord);
    }

    /**
     * Return the name of the game, Hangman.
     * @return string
     */
    @Override
    public String getName(){
        return gameName;
    }
}

