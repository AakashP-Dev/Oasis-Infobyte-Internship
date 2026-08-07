import java.util.Random;
import java.util.Scanner;

class Aakash_2{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int randomNumber = rand.nextInt(100)+1;

        while(true){
            System.out.print("Guess the Number(1-100): ");
            int guessedNumber = sc.nextInt();

            if(guessedNumber == randomNumber){
                System.out.println("Correct!");
                break;
            }
            else if(guessedNumber > randomNumber){
                System.out.println("Too High!");
            }
            else if(guessedNumber < randomNumber){
                System.out.println("Too Low!");
            }
        }
    }
}