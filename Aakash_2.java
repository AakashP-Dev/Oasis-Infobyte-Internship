import java.util.Random;
import java.util.Scanner;

class Aakash_2{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int randomNumber = rand.nextInt(100)+1;
        int attemptCount = 1;

        while(true){
            System.out.println("Attempt no: " + attemptCount);
            System.out.print("Guess the Number(1-100): ");
            int guessedNumber = sc.nextInt();

            if(guessedNumber == randomNumber){
                System.out.println("Correct!");
                System.out.println("You took " + attemptCount + " Attempts.");
                break;
            }
            else if(guessedNumber > randomNumber){
                System.out.println("Too High!");
            }
            else if(guessedNumber < randomNumber){
                System.out.println("Too Low!");
            }
            attemptCount++;
        }
    }
}