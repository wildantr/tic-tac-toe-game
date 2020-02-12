/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Scanner;

/**
 *
 * @author wildantr
 */
public class gameTest {
    // the game status and game board
    private char gameBoard[][]; // the game board on 2D Display

    private final int rows = 4; // number of rows
    private final int cols = 4; // number of cols

    private char currentPlayer; // the player x or o

    public static void main(String[] args) { //
        gameTest game = new gameTest();
        game.start();
    }
    
    private enum gameStatus { // status game
        WINNER, // status game win
        DRAW, // status game draw
        PROCESS // status game process
    }

    private static Scanner input = new Scanner(System.in); // the input scanner

    //**********************************initialization*************************
    // method for initialization
    private void initializationBoard() {
        // looping to make the initial board match the specified rows and cols
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gameBoard[i][j] = '?';
            }
        } 
        char player1; // initialization player one
        char player2; // initialization player two
        // example to determine player x or o
        if (currentPlayer == 'x') { // if player pressing the x
            player1 = 'x'; // then player one x and
            player2 = 'o'; // player two o
            // print messages
            System.out.println("Player 1 : " + player1);
            System.out.println("Player 2 : " + player2);
        } else if (currentPlayer == 'o') { // if player pressing the o
            player1 = 'o'; // then player one o and
            player2 = 'x'; // and player two x
            // print messages
            System.out.println("Player 1 : " + player1);
            System.out.println("Player 2 : " + player2);
        }

    }//end of method initializationBoard()
    //**********************************end of initialization*************************
            
    
    //************************************show board***********************//
    // method for show the board of tic tac toe simple game
    private void showBoard() {
        // looping to make the initial board match the specified rows and cols
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(gameBoard[i][j] + " | ");
            }
            // print messages
            System.out.println();
            System.out.println("--------------");
        }
    }//end of method showBoard()
    //************************************end of show board***********************//
    
    
    public gameTest() {
        gameBoard = new char[rows][cols]; // create gameboard new char rows and cols
        // print messages
        System.out.println("Welcome To Tic Tac Toe Simple Game");
        System.out.println("==================================");

        // choose the player x or n
        do {
            // print messages
            System.out.print("please enter 1 to select the x character, "
                    + "or 2 for o characters, "
                    + "then press enter. your choice : ");
            int selectCharacter = input.nextInt(); // input 1 or 2
            if (selectCharacter == 1) { // if 1 print message and choose x player 
                currentPlayer = 'x';
            } else if (selectCharacter == 2) { // if 2 print message and choose o player 
                currentPlayer = 'o';
            } else { // if the options do not match then a message appears
                System.out.println("your choice is invalid !n");
                System.out.println("==================================");
            }
        } while (checkSelectCharacter(currentPlayer) == false); // if the options do not match then print choose the player again
        initializationBoard(); // call function method initializationBoard()
        showBoard(); // call function method showBoard()
    } 

    
    //*************************check select character*****************************//
    // method that has a function to check the player in selecting characters to be played with valid
    private boolean checkSelectCharacter(char currentPlayer) {
        boolean selectCharacter = false; // selectCharacter is boolean which will return true or false
        if (currentPlayer == 'x' || currentPlayer == 'o') {
            selectCharacter = true;
        } else {
            selectCharacter = false;
        }
        return selectCharacter;
    }// end of method checkSelectCharacter()
    //*************************end of check select character*****************************//
  
    
    //*************************swap player*************************************//
    // method to check the players turn
    private void swapPlayer() {
        // if current player x then o
        if (currentPlayer == 'x') {
            currentPlayer = 'o';
        } else { // if current player o then x
            currentPlayer = 'x';
        }
    }// end of method swapPlayer()
    //*************************end of swap player*************************************//
    
    
    //**************************check winner*************************************//
    // method for checking three values ​​is the same and not empty in the row or column
    private boolean checkRowsColumn(char a1, char a2, char a3, char a4) {
        // return value by using and
        return ((a1 != '?') && (a1 == a2) && (a2 == a3) && (a3 == a4));
    }// end of method checkRowsColumn
        
    // method for checking the winning row
    private boolean checkRowsWinner() {
        // looping to see rows, if all rows are of the same value it will return a value
        for (int i = 0; i < rows -1; i++) {
            if (checkRowsColumn(gameBoard[i][0], gameBoard[i][1], gameBoard[i][2], gameBoard[i][3]) == true) {
                return true;
            }
        }
        return false;
    }// end of method checkRowsWinner()

    // method for checking the winning cols
    private boolean checkColsWinner() {
        // looping to see cols, if all cols are of the same value it will return a value
        for (int i = 0; i < cols; i++) {
            if (checkRowsColumn(gameBoard[0][i], gameBoard[1][i], gameBoard[2][i], gameBoard[3][i]) == true) {
                return true;
            }
        }
        return false;
    }// end of method checkColsWinner()

    // method for checking the winning diagonal
    private boolean checkDiagonalWinner() {
        // looping to see diagonal, if all diagonal are of the same value it will return a value
        return ((checkRowsColumn(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2], gameBoard[3][3]) == true)
                || (checkRowsColumn(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0], gameBoard[0][1]) == true));
    }// end of method checkDiagonalWinner()
        
    // method check for player win
    private boolean checkWinner() {
        // return value method of checkRowsWinner(), checkColsWinner(), checkDiagonalWinner() by using or
        return (checkRowsWinner() || checkColsWinner() || checkDiagonalWinner());
    }// end of method checkWinner()
    //************************end of check winner***********************************//
    
    
    //******************************check draw***************************************//
    // method to check the condition of the game board is full or not
    private boolean checkDraw() {
        boolean draw = true; // draw initiation is boolean and true
        // looping to determine draw or not, by looking at the value of rows and cols
        for (int i = 0; i < rows; i++) { // loop rows
            for (int j = 0; j < cols; j++) { // loop cols
                if (gameBoard[i][j] == '?') { // if gameBoard() rows and cols worth ? then draw false
                    draw = false;
                }
            }
        }
        return draw;
    }// end of method checkDraw()
    //******************************end of check draw**********************************//

    
    //************************check game status************************************//
    // method to check game status win, draw or process
    private gameStatus statusNow() {
        if (checkWinner() == true) { // check method checkWinner is true, return gamestatus.WINNER
            return gameStatus.WINNER;
        } else if (checkDraw() == true) { // check method checkDraw is true, return gamestatus.DRAW
            return gameStatus.DRAW;
        } else {
            return gameStatus.PROCESS; // if not all, return gamestatus.PROCESS
        }
    }

    private void showStatus() {
        gameStatus status = statusNow();
        if (status == gameStatus.WINNER) { // if gameStatus value is Winner then show messages
            System.out.println("PLAYER " + currentPlayer + " WIN !!");
        } else if (status == gameStatus.DRAW) { // if gameStatus value is Draw then show messages
            System.out.println("The Game Ends DRAW !!");
        }
    }
    //******************************end of check game status*****************************//

    
    //***********************************input character******************************//
    // method for input character
    private void inputCharacter() {
        checkWinner(); // call method checkWinner()
        checkDraw(); // call method CheckDraw()
        statusNow(); // call statusNow()

        // print messages
        System.out.print("Player " + currentPlayer
                + " choose your rows (1-4): ");
        int row = input.nextInt() -1; // input rows and value -1 because array start with 0
        System.out.print("Pemain " + currentPlayer
                + " choose your cols (1-4): "); // input cols and value -1 because array start with 0
        int col = input.nextInt() -1;
        
        // condition when
        if ((row < 0) || (row > rows -1)) { // if value rows below 0 and above 4 then print message
            System.out.println("Rows not valid, try again...");
        } else if ((col < 0) || (col > cols -1)) { // if value cols below 0 and above 4 then print message
            System.out.println("Cols not valid, try again...");
        } else if (gameBoard[row][col] != '?') { // if value rows and cols not ? then print message
            System.out.println("area already filled, try again...");
        } else {
            markBoard(row, col, currentPlayer);
            showBoard();
            if (statusNow() == gameStatus.PROCESS) {
                swapPlayer();
            }

        }
    }// end of method input character

    
    //***********************************mark board********************************//
    // player mark board with character
    private void markBoard(int row, int col, char playerMark) {
        gameBoard[row][col] = playerMark;
    }// end of method markBoard

    //************************************START GAME***********************************//
    public void start() {
        do {
            inputCharacter();
        } while (statusNow() == gameStatus.PROCESS);
        showStatus();
    }//Akhir method start()
}
