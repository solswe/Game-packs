//Name: Sol Kim

import java.util.Random;
import java.util.Scanner;

public class GameGrabber {
    private Game[] games;
    private Scanner user;

    /**
     * Constructor of GameGrabber.
     * Set variables.
     * @param games
     * @param user
     */
    public GameGrabber(Game[] games, Scanner user){
        this.games = games;
        this.user = user;
    }

    /**
     * Show a list of games, and let a user pick a game.
     * Repeat it until a user choose to quit.
     */
    public void doMenu(){
        int input = -100; //-100 is just a random number for while loop.

        while (input != games.length){
            for (int i = 0; i < games.length; i++) {
                String x = games[i].getName();
                System.out.println(i + ") " + x);
            }
            System.out.println(games.length + ") Quit");

            while ((input < 0) || (input > games.length)) {
                System.out.print("Pick a game (0-" + games.length + ") ");
                input = user.nextInt();
            }
            if (input == games.length) {
                System.out.println("goodbye");
                return;
            } else {
                games[input].play(user);
            }
            input = -100;
        }
    }

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        Random rng = new Random();
        WordsList wordslist = new WordsList(rng);

        Hangman hm = new Hangman(wordslist, 1, 10, 20);
        NumberGuesser ng = new NumberGuesser(rng, 300, 10);
        RPS rps = new RPS(rng, 3, 3);
        WordJumble wj = new WordJumble(wordslist, rng, 1, 10, 10);
        //Bingo bg = new Bingo(rng, 2);
        Game[] games = new Game[]{hm, ng, rps, wj};

       GameGrabber gamegrabber = new GameGrabber(games, scnr);
       gamegrabber.doMenu();
    }
}
