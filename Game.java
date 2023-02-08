//Name: Sol Kim

import java.util.Scanner;

public abstract class Game {

    protected abstract String prepToPlay();

    protected abstract boolean isOver();

    protected abstract boolean isValid(String move);

    protected abstract String processMove(String move);

    protected abstract String finalMessage();

    public abstract String getName();

    public void play(Scanner user) {
        System.out.println(prepToPlay());
        System.out.print("Enter Your Move or 'quit' to quit> ");

        while (isOver() == false) {
            String userInput = user.next();
            if (userInput.equals("quit")) {
                System.out.println(finalMessage());
                return;
            }

            if (isValid(userInput) == false) {
                if (isOver() == true) {
                    System.out.println(finalMessage());
                    return;
                }
                System.out.print("Invalid Move! try again> ");
            }
            else {
                if (processMove(userInput) != null){
                    System.out.println(processMove(userInput));
                }
                if (isOver() == true) {
                    System.out.println(finalMessage());
                    return;
                }
                System.out.print("Enter Your Move or 'quit' to quit> ");
            }
        }
    }
}



