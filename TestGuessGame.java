import java.util.Random;
import java.util.Scanner;

class GuessGame{
    private int hiddenNumber;
    private int attempts;
    private int score;

    int maxAttempts = 7;

    public void generateNumber(int low, int high){
        Random rand = new Random();
        hiddenNumber = low + rand.nextInt(high - low + 1);
    }

    public void playRound(int low, int high) {
        Scanner sc = new Scanner(System.in);
        attempts = 0;
        generateNumber(low, high);
        boolean correct = false;
        while (!correct && attempts < maxAttempts) {
            System.out.println("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;
            correct = checkGuess(guess);
        }
        if (correct){
            System.out.println("player won!");
            score++;
        }else {
            System.out.println("player ran out of attempts!" +);
            System.out.println("The Number is: " + hiddenNumber);
        }
    }

    public boolean checkGuess(int guess) {
        if (guess == hiddenNumber) {
            System.out.println("you got it!");
            return true;
        } else if (guess > hiddenNumber) {
            System.out.println("too high!");
            return false;
        } else {
            System.out.println("too low!");
            return false;
        }
    }

    public void displayScore(){
        System.out.println("Score: " + score);
    }
}

class TestGuessGame {
    public static void main(String[] arr) {
        GuessGame g = new GuessGame();
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            g.playRound(1, 100);
            g.displayScore();

            System.out.println("Play again? (y/n)");
            String answer = sc.next();
            if (answer.equals("n")) {
                playAgain = false;
            }
        }
    }
}
