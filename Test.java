import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
         // declaring new array 3 * 3 where the the game takes place
        char[][] ticTacToe = new char[3][3];
        for (int i = 0; i < 9; i++) {
            ticTacToe [i % 3][i / 3] = ' ';
        }
        
        // start playing Tic-tac-toe :
        play(ticTacToe);
        
    }
    
    /* 
        function for printing the current state of the game 
    */
    public static void printTheGame (char[][] game) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    
    /*
        playing the Game :
            1 # input: the cell where user wants to play
            2 # check: if the player entered a valid input
            3 # check: if the play's chosen cell that already been occupied
            4 # print: current game state after the new move is played
            5 # check: after 5 moves one of the playes reach 3 moves and the other one 2 moves so we check if there's a winner 
    */
    public static void play (char game[][]) {

        Scanner input = new Scanner(System.in);

        int freeCellsCounter = 9;

        printTheGame(game);

        String a;
        String b;

        while (freeCellsCounter > 0) {
            while (true) {

                System.out.println("Enter the coordinates: ");

                a = input.next();
                b = input.next();
                if ((a.charAt(0) == '1' || a.charAt(0) == '2' || a.charAt(0) == '3') &&
                        (b.charAt(0) == '1' || b.charAt(0) == '2' || b.charAt(0) == '3')) {

                    if (game[((int) a.charAt(0)) - 1 - 48][((int) b.charAt(0)) - 1 - 48] == ' ') {

                        if (freeCellsCounter % 2 != 0) {
                            game[((int) a.charAt(0)) - 1 - 48][((int) b.charAt(0)) - 1 - 48] = 'X';
                            printTheGame(game);
                            break;
                        } else {
                            game[((int) a.charAt(0)) - 1 - 48][((int) b.charAt(0)) - 1 - 48] = 'O';
                            printTheGame(game);
                            break;
                        }

                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }

                } else {
                    System.out.println("You should enter numbers!");
                }
            }

            int winner = 0;
            if (freeCellsCounter <= 4) {
                // returned value carring winner name or no winner
                winner = checkingWinner(game);
            }

            freeCellsCounter--;

            if (winner == 0 && freeCellsCounter == 0) {
                System.out.println("Draw");
            } else if (winner == 1) {
                System.out.println("X wins");
                break;
            } else if (winner == 2) {
                System.out.println("O wins");
                break;
            }

        }
    }

    
    /* 
        checking winner: 3 in arow , 3 in a coulmn or 3 diagonally 
    */
    public static int checkingWinner (char[][] game) {

        // 0 --> non, 1 --> X, 2 --> O

        for (int i = 0; i < 3; i++) {

            if (game[i][0] == 'X' && game[i][1] == 'X' && game[i][2] == 'X') {
                return 1;
            } else if (game[i][0] == 'O' && game[i][1] == 'O' && game[i][2] == 'O') {
                return 2;
            }
            if (game[0][i] == 'X' && game[1][i] == 'X' && game[2][i] == 'X') {
                return 1;
            } else if (game[0][i] == 'O' && game[1][i] == 'O' && game[2][i] == 'O') {
                return 2;
            }

        }

        if (game[0][0] == 'X' && game[1][1] == 'X' && game[2][2] == 'X') {
            return 1;
        } else if (game[0][0] == 'O' && game[1][1] == 'O' && game[2][2] == 'O') {
            return 2;
        }
        if (game[0][2] == 'X' && game[1][1] == 'X' && game[2][0] == 'X') {
            return 1;
        } else if (game[0][2] == 'O' && game[1][1] == 'O' && game[2][0] == 'O') {
            return 2;
        }
        return 0;
    }

}
