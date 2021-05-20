import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

import javax.print.DocFlavor.STRING;

class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to tic-tac-toe\n\n");

    String[] board = {" ", "x", " ", "x", "o", "o", " ","o", "x"};
    positionBoard();
    System.out.println("\n\nLet's play!!\n");
    emptyBoard(board);

    Scanner input = new Scanner(System.in);

    int countTurn = 0;

    // TODO correct the checkGameOver method to actually evaluate and end game correctly
    // TODO make while loop exit after all parts of board are completed
    while(countTurn<board.length){
      System.out.print("\nWhere would you like to make your move. Enter the number: ");
      int move = input.nextInt();
      if ((countTurn == 0 || countTurn % 2 == 0) && playersMove(board, move, "o")){
        displayBoard(board); positionBoard();
        if (checkGameOver(board)){break;}
        countTurn++;
      }
      else if (countTurn % 2 != 0 && playersMove(board, move, "x")){
       
        displayBoard(board); positionBoard();
        if (checkWinner(board) || checkGameOver(board)){break;} 
        countTurn++;
      } 
    }
    
  }
  
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

  public static void displayBoard(String[] boardValue){
    System.out.println(" "+boardValue[0]+" | "+boardValue[1]+ " | "+boardValue[2]);
    System.out.println("___________");
    System.out.println(" "+boardValue[3]+" | "+boardValue[4]+ " | "+boardValue[5]);
    System.out.println("___________");
    System.out.println(" "+boardValue[6]+" | "+boardValue[7]+ " | "+boardValue[8]);
    System.out.println("+******************************+");
  }

  public static boolean playersMove(String[] board, int pMove, String play){

       if (validMove(board, pMove)){
            board[pMove] = play;
            return true;
       }
       else{
        System.out.println("Invalid Move!");
        return false;
       }

      //return board[pMove];
  }   

  public static boolean validMove(String[] board, int pMove){
    if ((board[pMove] == " ") && (!board[pMove].isEmpty())){
            return true;
       }
       else{
         return false;
       }

  }

  public static boolean checkWinner(String[] board){
    // String[] newArray = Arrays.copyOfRange(oldArray, startIndex, endIndex);
    //Arrays.copyOfRangeboard(board, 0, 2);

    // String[] play = Arrays.copyOfRangeboard(board, 0, 2);
   
    // if (Arrays.copyOfRange(board, 0, 3) == "x" ||
    // Arrays.copyOfRange(board, 0, 3) == "o" ){
    //   System.out.println("You won!!1");
    //   return "gameover";
    // }


  
    boolean checkOwins = (board[0] == "o" && board[1] == "o" && board[2] == "o" ) || (board[3] == "o" && board[4] == "o" && board[5] == "o" ) || (board[6] == "o" && board[7] == "o" && board[8] == "o" );

    boolean checkX = (board[0] == "x" && board[1] == "x" && board[2] == "x" ) || (board[3] == "x" && board[4] == "x" && board[5] == "x" ) || (board[6] == "x" && board[7] == "x" && board[8] == "x" );

    boolean checkOwinsV = (board[0] == "o" && board[3] == "o" && board[6] == "o" ) || (board[1] == "o" && board[4] == "o" && board[7] == "o" ) || (board[2] == "o" && board[5] == "o" && board[8] == "o" );

    boolean checkXV = (board[0] == "x" && board[3] == "x" && board[6] == "x" ) || (board[1] == "x" && board[4] == "x" && board[7] == "x" ) || (board[2] == "x" && board[5] == "x" && board[8] == "x" );

    boolean checkOwinsCross = (board[0] == "o" && board[4] == "o" && board[8] == "o" ) || (board[2] == "o" && board[4] == "o" && board[6] == "o" );

    boolean checkXCross = (board[0] == "x" && board[4] == "x" && board[8] == "x" ) || (board[2] == "x" && board[4] == "x" && board[6] == "x");

    // if (Arrays.copyOfRange(board, 0, 3) == "x"){
    //   System.out.println("You won!!1");}

    //findSlice(board,0,3);

    if (checkOwins || checkOwinsV || checkOwinsCross){
      System.out.println("You won O!!");
      return true;
    } else if(checkX || checkXV || checkXCross) {
      System.out.println("You won X!!");
      return true;
    } else{return false;}
  
  }

  /** This method returns the copy of a slice of the list*/
  public static int[] findSlice(int[] board, int startIndex, int endIndex){

    int[] slice = IntStream.range(startIndex, endIndex).map(i -> board[i]).toArray();

    return slice;
  }

  /** This methods checks to see if the game is over
  or if there are no moves left*/
  public static boolean checkGameOver(String[] board){
    //if (the number of empty string elements in array is <= 2) game over == true;

    int counter= 0;
    for (String i: board){
      if (i == " ");
      counter++;
    }

    if (checkWinner(board)){
      System.out.println("GAME OVER!!!!");
      return true;
    }
    else if ((counter <= 2) && !Main.checkWinner(board)){
      System.out.println("GAME OVER!!!!");
      return true;
    }
    else{
      return false;
    }
  }

}