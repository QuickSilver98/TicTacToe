import java.util.Scanner;
import java.util.Random;
public class TicTacToe {

    public static void main(String[] args) {
        Game gameObject = new Game();
        intro(gameObject);

            for (int i = 0; i < 20; i++) {
                playerMove(gameObject);
                computerMove(gameObject);

            }

    }

    private static void computerMove(Game gameObject) {
        Random rand = new Random();
        int computerMove = rand.nextInt(9) + 1;
        while(true){
            if(isValidMove(gameObject,computerMove)){
                break;
            }
        }
        placeMove(gameObject,Integer.toString(computerMove),'O');
        gameObject.printBoard();
        isGameFinished(gameObject);

    }

    private static void playerMove(Game gameObject) {
        Scanner input = new Scanner(System.in);
        String userInput;
        System.out.println("Enter a number(1-9)to place your piece");
        userInput = input.nextLine();
        while(true){
            if(isValidMove(gameObject, Integer.parseInt(userInput))){
                break;
            }else {
                System.out.println("Enter a valid move");
                userInput = input.nextLine();
            }
          input.nextLine();
        }

        placeMove(gameObject, userInput, 'X');
        isGameFinished(gameObject);

    }

    private static void placeMove(Game gameObject, String position,char symbol) {
        switch (position) {
            case "1" -> gameObject.board[0][0] = symbol;
            case "2" -> gameObject.board[0][2] = symbol;
            case "3" -> gameObject.board[0][4] = symbol;
            case "4" -> gameObject.board[2][0] = symbol;
            case "5" -> gameObject.board[2][2] = symbol;
            case "6" -> gameObject.board[2][4] = symbol;
            case "7" -> gameObject.board[4][0] = symbol;
            case "8" -> gameObject.board[4][2] = symbol;
            case "9" -> gameObject.board[4][4] = symbol;
            default -> System.out.println(":(");
        }
    }

    public static void intro(Game gameObject){
        System.out.println("Tic Tac Toe!!");
        gameObject.showOptions();
    }


    private static boolean isValidMove(Game gameObject,int position){
        return switch (position) {
            case 1 -> gameObject.board[0][0] == ' ';
            case 2 -> gameObject.board[0][2] == ' ';
            case 3 -> gameObject.board[0][4] == ' ';
            case 4 -> gameObject.board[2][0] == ' ';
            case 5 -> gameObject.board[2][2] == ' ';
            case 6 -> gameObject.board[2][4] == ' ';
            case 7 -> gameObject.board[4][0] == ' ';
            case 8 -> gameObject.board[4][2] == ' ';
            case 9 -> gameObject.board[4][4] == ' ';
            default -> false;
        };
    }

    public static void isGameFinished(Game gameObject){

        if(checkWin(gameObject,'X')){
            gameObject.printBoard();
            System.out.println("Player wins");
            System.exit(0);
        }


        if(checkWin(gameObject,'O')){
            gameObject.printBoard();
            System.out.println("Computer wins");
            System.exit(0);
        }

        for(int i =0; i < gameObject.board.length; i++){
            for(int j = 0; j < gameObject.board[i].length; j++){
                if(gameObject.board[i][j] == ' '){
                    return;
                }
            }
        }
        gameObject.printBoard();
        System.out.println("Game is a tie");

    }

    public static boolean checkWin(Game gameObject,char symbol){
        return (gameObject.board[0][0] == symbol && gameObject.board[0][2] == symbol && gameObject.board[0][4] == symbol) ||
                (gameObject.board[2][0] == symbol && gameObject.board[2][2] == symbol && gameObject.board[2][4] == symbol) ||
                (gameObject.board[4][0] == symbol && gameObject.board[4][2] == symbol && gameObject.board[4][4] == symbol) ||


                (gameObject.board[0][0] == symbol && gameObject.board[2][0] == symbol && gameObject.board[4][0] == symbol) ||
                (gameObject.board[0][2] == symbol && gameObject.board[2][2] == symbol && gameObject.board[4][2] == symbol) ||
                (gameObject.board[0][4] == symbol && gameObject.board[2][4] == symbol && gameObject.board[4][4] == symbol) ||

                (gameObject.board[0][0] == symbol && gameObject.board[2][2] == symbol && gameObject.board[4][4] == symbol) ||
                (gameObject.board[0][4] == symbol && gameObject.board[2][2] == symbol && gameObject.board[4][0] == symbol);
    }
    }





