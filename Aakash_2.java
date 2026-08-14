import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
class Aakash_2{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        GuessTheNumber GTN = new GuessTheNumber();
        int result = 0;
        int round = 1;
        int loses = 0;
        int wins = 0;

        System.out.println("+==================+");
        System.out.println("| GUESS THE NUMBER |");
        System.out.println("+==================+");

        System.out.println("\n+=============================================+");
        System.out.print("Play Game? Yes/No: ");
        String startGame = sc.next();
        System.out.println("+=============================================+");

        switch (startGame.toLowerCase()) {
            case "yes", "y" -> {
            OUTER_2:
            while (true) {
                System.out.print("Which Difficulty would u like to play?\n1.Easy(1-50, 10 attempts)\n2.Medium(1-100, 7 attempts)\n3.Hard(1-200, 5 attemps)\nchoose(1, 2 or 3)>");
                int Difficulty = sc.nextInt();
                System.out.println("+=============================================+");
                switch (Difficulty) {
                    case 1 -> {
                        result = GTN.playGame(50, 10);
                        break OUTER_2;
                    }
                    case 2 -> {
                        result = GTN.playGame(100, 7);
                        break OUTER_2;
                    }
                    case 3 -> {
                        result = GTN.playGame(200, 5);
                        break OUTER_2;
                    }
                    default -> {
                        System.out.println("Invalid Input! Try Again.");
                        System.out.println("+=============================================+");
                    }
                }
            }
            }
            case "no", "n" -> {
                System.out.println("Thank you!");
                System.out.println("+=============================================+");
            }
            default -> {
                System.out.println("Invalid Input! Try again.");
                System.out.println("+=============================================+");
            }
        }

        if(result==1){
            wins++;            
        }
        else if(result==-1){
            loses++;
        }

        OUTER_1:
        while (true) {
            System.out.println("\n+=============================================+");
            System.out.print("Want to Play Again? Yes/No: ");
            String playAgain = sc.next();
            System.out.println("+=============================================+");
            switch (playAgain.toLowerCase()) {
                case "yes", "y" -> {
                    round++;
                    OUTER:
                    while (true) {
                        System.out.print("Which Difficulty would u like to play?\n1.Easy(1-50, 10 attempts)\n2.Medium(1-100, 7 attempts)\n3.Hard(1-200, 5 attemps)\nchoose(1, 2 or 3)>");
                        int Difficulty = sc.nextInt();
                        System.out.println("+=============================================+");
                        switch (Difficulty) {
                            case 1 -> {
                                result = GTN.playGame(50, 10);
                                break OUTER;
                            }
                            case 2 -> {
                                result = GTN.playGame(100, 7);
                                break OUTER;
                            }
                            case 3 -> {
                                result = GTN.playGame(200, 5);
                                break OUTER;
                            }
                            default -> {
                                System.out.println("Invalid Input! Try Again.");
                                System.out.println("+=============================================+");
                            }
                        }
                    }
                }
                case "no", "n" -> {
                    System.out.println("Your Played Total of " + round + " rounds");
                    System.out.println("Your Score is " + wins + " Wins and " + loses + " Loses.");
                    System.out.println("Thank you for playing!");
                    break OUTER_1;
                }
                default -> {
                    System.out.println("Invalid Input! Try again.");
                    System.out.println("+=============================================+");
                }
            }
            if(result==1){
                wins++;            
            }
            else if(result==-1){
                loses++;
            }
        }
    }
}

class GuessTheNumber{
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public int playGame(int range, int attempts){
        int randomNumber = rand.nextInt(range)+1;
        // System.out.println(randomNumber);
        int attemptCount = 1;
        int gameStatus = 0;
        

        while(true){
            System.out.println("Attempt no: " + attemptCount);
            System.out.print("Guess the Number(1-"+range+"): ");
            int guessedNumber = sc.nextInt();

            if(attemptCount<attempts){
                if(guessedNumber == randomNumber){
                    gameStatus = 1;
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
            }else{
                gameStatus = -1;
                System.out.println("You Lose");
                System.out.println("The Number was: " + randomNumber);
                break;
            }
            attemptCount++;
        }
        return gameStatus;
    }
}