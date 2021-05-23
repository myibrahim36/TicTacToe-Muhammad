import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

import javax.print.DocFlavor.STRING;

class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to tic-tac-toe\n\n");

    String[] board = {"o", "o", " ", " ", " ", " ", " "," ", " "};
    positionBoard();
    System.out.println("\n\nLet's play!!\n");
    emptyBoard(board);



    int countTurn = 0;

    while(!checkGameOver(board)){
      System.out.print("\nWhere would you like to make your move. Enter the number: ");
      Scanner input = new Scanner(System.in);
      int move = input.nextInt();
      if ((countTurn == 0 || countTurn % 2 == 0) && playersMove(board, move, "o")){

        displayBoard(board); positionBoard();
        if (checkGameOver(board)){break;}
        countTurn++;
      }
      else if (countTurn % 2 != 0 && playersMove(board, move, "x")){
       
        displayBoard(board); //positionBoard();
        if (checkGameOver(board)){break;} 
        countTurn++;
      } 
    }
    
  }
  
  /** This method houses our position board. Lets players know how to navigate on the board*/
  public static void positionBoard(){
    System.out.println(" 0 | 1 | 2 ");
    System.out.println("___________");
    System.out.println(" 3 | 4 | 5 ");
    System.out.println("___________");
    System.out.println(" 6 | 7 | 8 ");
  }

  public static void emptyBoard(String[] board){
    System.out.println("  "+board[0]+"| "+board[1]+ " | "+board[2]);
    System.out.println("___________");
    System.out.println(" "+board[3]+" | "+board[4]+ " | "+board[5]);
    System.out.println("___________");
    System.out.println(" "+board[6]+" | "+board[7]+ " | "+board[8]);

  }

  /** This method houses our game board*/
  public static void displayBoard(String[] boardValue){
    System.out.println(" "+boardValue[0]+" | "+boardValue[1]+ " | "+boardValue[2]);
    System.out.println("___________");
    System.out.println(" "+boardValue[3]+" | "+boardValue[4]+ " | "+boardValue[5]);
    System.out.println("___________");
    System.out.println(" "+boardValue[6]+" | "+boardValue[7]+ " | "+boardValue[8]);
    System.out.println("+******************************+");
  }

  /** This method lets the player know if a move they made was right, and alerts them if it wasn't*/
  public static boolean playersMove(String[] board, int pMove, String play){

       if (validMove(board, pMove) && !checkGameOver(board)){
            board[pMove] = play;
            return true;
       }
       else if (checkGameOver(board)){
         return true;
       }
       else{
        System.out.println("Invalid Move!");
        return false;
       }
  }   

  /** This method validates a move  and returns true if that move is valid*/
  public static boolean validMove(String[] board, int pMove){
    if ((board[pMove] == " ") && (!board[pMove].isEmpty())){
            return true;
       }
       else{
         return false;
       }

  }

  /** This method checks the board for plays that win.*/
  public static boolean checkWinner(String[] board){

  int[][] winningNumbers = {{0,1,2},{3,4,5},{6,7,8},
                    {0,3,6},{1,4,7},{2,5,8},
                    {0,4,8},{2,4,6}};
    
    boolean win = false;

    for(int i = 0; i < winningNumbers.length; i++){
      int[] winningNumber = winningNumbers[i];
      int firstIndex = winningNumber[0];
      int secondIndex = winningNumber[1];
      int thirdIndex = winningNumber[2];

      if (board[firstIndex] == "o" && board[secondIndex] == "o" && board[thirdIndex] == "o"){ 
        System.out.println("You won O!!");
        System.out.println("test here22");
        win = true;        
      }
      else if (board[firstIndex] == "x" && board[secondIndex] == "x" && board[thirdIndex] == "x"){ 
        System.out.println("You won x!!");
        System.out.println("test here");
        win = true;        
      }
      else{win = false;}
    }
    return win;
  }

  /** This methods checks to see if the game is over
  or if there are no moves left*/
  public static boolean checkGameOver(String[] board){
    int counter= 0;
    for (String i: board){
      if (i == " "){counter++;}
      
    }

    if (checkWinner(board)){
      System.out.println("GAME OVER!!!!");
      return true;
    } 
    else if (counter == 0){
      System.out.println("GAME OVER!!!!");
      return true;
    }
    else{
      return false;
    }
  }

}