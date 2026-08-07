import java.util.Random;
import java.util.Scanner;

class Aakash_2{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        GuessTheNumber GTN = new GuessTheNumber();

        System.out.println("+==================+");
        System.out.println("| GUESS THE NUMBER |");
        System.out.println("+==================+");

        System.out.println("\n+=============================================+");
        System.out.print("Start the Game? Yes/No: ");
        String startGame = sc.next();
        System.out.println("+=============================================+");

        switch (startGame.toLowerCase()) {
            case "yes":
            case "y":
                GTN.playGame();
                break;
            case "no":
            case "n":
                System.out.println("Thank you!");
                System.out.println("+=============================================+");
                break;
            default:
                System.out.println("Invalid Input! Try again.");
                System.out.println("+=============================================+");
                break;
        }
    }
}

class GuessTheNumber{
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public void playGame(){
        int randomNumber = rand.nextInt(100)+1;
        System.out.println(randomNumber);
        int attemptCount = 1;

        while(true){
            System.out.println("Attempt no: " + attemptCount);
            System.out.print("Guess the Number(1-100): ");
            int guessedNumber = sc.nextInt();

            if(guessedNumber == randomNumber){
                System.out.println("Correct!");
                System.out.println("You took " + attemptCount + " Attempts.");
                System.out.println("+=============================================+");
                break;
            }
            else if(guessedNumber > randomNumber){
                System.out.println("Too High!");
                System.out.println("+=============================================+");
            }
            else if(guessedNumber < randomNumber){
                System.out.println("Too Low!");
                System.out.println("+=============================================+");
            }
            attemptCount++;
        }
    }
}