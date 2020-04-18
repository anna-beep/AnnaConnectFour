//import the Scanner class used for user input
import java.util.Scanner;
//System.out.println("Welcome to the Connect 4 Game, you are x, the computer is o.")
public class Runner {
    public static void main(String[] args) {
        Human anna = new Human("Anna", "x");
        Computer computer = new Computer("o");
        Scanner scanner =  new Scanner(System.in);
        Board board = new Board();

        //game loop - alternate moves?
        while(!board.checkWin(anna.token))  {
            boolean colAllowed = false;
            int moveCol = -1;

            //human makes move: validates their input and move
            while(!colAllowed) {

//               System.out.println("Enter column to move:");
//                //hasNextInt will then return true if user input is an int
//                if(scanner.hasNextInt()) {
//                    moveCol = scanner.nextInt();
//                    colAllowed = true;
//                }
//                else {
//                    System.out.println("Please enter a legal row (aka a real integer)");
//                    scanner.next();  //very important, resets the input from the "bad" one
//                }

                //move to correct column
                System.out.println("Enter column to move:");
                //hasNextInt will return true if user input is an int
                if(scanner.hasNextInt()) {
                    moveCol = scanner.nextInt()-1;
                    colAllowed = true;
                    if (moveCol>8 || moveCol<1){
                        System.out.println("Enter a legal column!");
                        colAllowed=false;
                        scanner.next();
                    }
//                    if(moveCol<8&& !board.colHasRoom(moveCol)){
//                        System.out.println("");
//                    }
                }
                else {
                    System.out.println("Enter a legal column (aka a real integer)");
                    scanner.next();  //very important, resets the input from the "bad" one
                }

                if(colAllowed) {
                    board.makeMove(moveCol,anna.token);
                }
            }


            //computer move
            int[] cMove = computer.determineMove();
            board.makeMove(cMove[0], computer.token);

            //all done moving, display and repeat
            board.printBoard();
        }
        System.out.print("Game Over!");
    }
}
