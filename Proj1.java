package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Proj1 {
    public static void main (String [] args) throws InputMismatchException{

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("--------------------------\n");
        System.out.println("Welcome to Tic Tac Toe Game :) \n");

        System.out.println("Tic-tac-toe is a game in which two players take turns in enter either an \"O\" or an \"X\" \n in one square of a grid consisting of nine squares.\n" +
                " The winner is the first player to get three of the same symbols in a row.");

        System.out.println("--------------------------\n");

        int roundNum = 0;
        do {
            System.out.println("Choose one of these two options: ");
            System.out.println("1. Play one round: ");
            System.out.println("2. Play \"3\" rounds: ");

            try {
                roundNum = scanner.nextInt();
                scanner.nextLine();

                if (roundNum != 1 && roundNum != 2) {
                    throw new InputMismatchException();
                }

            }catch (InputMismatchException e) {
                System.out.println("Incorrect input! You must enter either \"1\" or \"2\" : ");
                System.out.println();
                scanner.nextLine();
                continue;
            }

            int userCount = 0;
            int compCount = 0;
            int drawCount = 0;


            if (roundNum == 2) {    //3 rounds

                for (int r = 0; r < 3; r++) {

                    String [][] array = new String[3][3];
                    clearGameBoard(array);  // Calling it To create a new empty(1-9) array, before each round

                    System.out.println("Round " + (r + 1) + " is start now!");
                    System.out.println();

                    int check = gameFlow();
                    if (check == 2)
                        userCount++;
                    else if (check == 1)
                        compCount++;
                    else drawCount++;

                } //End for
                checkIfRounds(userCount, compCount);
            } //End if

            else if (roundNum == 1) {
                int check = gameFlow();
                if (check == 2)
                    userCount++;
                else if (check == 1)
                    compCount++;
                else drawCount++;

                checkIfRounds(userCount, compCount);

            } //End else-if
           break;
        }while (true);


        System.out.println();

    } //End of main method



////////////////////  Methods :


    public static int gameFlow() {

        Scanner scanner = new Scanner(System.in);

        String[][] arrayGame = {
                {"1", "2", "3"},    //row1
                {"4", "5", "6"},    //row2
                {"7", "8", "9"}     //row3

        };  //2D Array with 3X3 size-- 3 rows and 3 columns

        System.out.println("Original Board Game: ");
        gameBoardDisplay(arrayGame);  //Calling this method to create initial board game


        System.out.println("Ready? enter either \"O\" or \"X\" to start the game : ");
        String userChoice = scanner.nextLine().toUpperCase(); //User choice

        while (!userChoice.equals("O") && !userChoice.equals("X")) {
            System.out.println("Incorrect input!. Please enter either \"O\" or \"X\": ");
            userChoice = scanner.nextLine().toUpperCase();
        }

        String computerChoice = null;

        if (userChoice.equals("X")) {      //Check if computer choice not same as a user choice
            computerChoice = "O";

        } else computerChoice = "X";

        System.out.println();

        boolean gameStarting = true;

        while (gameStarting) {  //Start while loop

            userTurn(arrayGame, userChoice);
            System.out.println("Your Turn: ");
            gameBoardDisplay(arrayGame);

            if (whoIsWinner(arrayGame, userChoice)) {
                System.out.println("Fantastic game! ");
                return 2;

            }

            //Check if the game end with no one has win, but after check if there is a winner

            if (checkDraw(arrayGame)) {
                System.out.println("The game ends in draw. Thanks for playing!");
                return 0;
            }


            computerTurn(arrayGame, computerChoice);
            System.out.println("Computer's Turn: ");
            gameBoardDisplay(arrayGame);

            System.out.println("**********************************");

            if (whoIsWinner(arrayGame, computerChoice)) {
                System.out.println("Computer is the winner..");
                return 1;

            }

            if (checkDraw(arrayGame)) {
                System.out.println("The game ends in draw. Thanks for playing!");
                return 0;
            }

            System.out.println();


        }  //End while loop
           return 0;
    } //End gameFlow method


/////////////////////////////////////////////////////


    public static void gameBoardDisplay(String [][] array){

        System.out.println(array[0][0] +" | " +  array[0][1] + " | " + array[0][2]);
        System.out.println("--*---*--");
        System.out.println(array[1][0] +" | " +  array[1][1] + " | " + array[1][2]);
        System.out.println("--*---*--");
        System.out.println(array[2][0] +" | " +  array[2][1] + " | " + array[2][2]);
        System.out.println();


    } //End of gameBoardDisplay method

    /////////////////////////////////////////////////////

    public static void userTurn(String [][] arr, String userChoice){

        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Please enter a position you want it: ");
                String userPos = scanner.nextLine();
                System.out.println();

                int intUserPos = Integer.parseInt(userPos);

                if (intUserPos < 1 || intUserPos > 9) {



                    System.out.println("Incorrect input!. You must enter a position in this range 1-9");
                    userPos = scanner.nextLine();


                }  //End if

                if (!checkEmptyPos(arr, userPos)) {

                    System.out.println("This position is already filled, please enter another position:");
                    userPos = scanner.nextLine();
                }


                if (userPos.equals("1")) {
                    arr[0][0] = userChoice;

                }
                if (userPos.equals("2")) {
                    arr[0][1] = userChoice;

                }
                if (userPos.equals("3")) {
                    arr[0][2] = userChoice;

                }
                if (userPos.equals("4")) {
                    arr[1][0] = userChoice;

                }
                if (userPos.equals("5")) {
                    arr[1][1] = userChoice;

                }
                if (userPos.equals("6")) {
                    arr[1][2] = userChoice;

                }
                if (userPos.equals("7")) {
                    arr[2][0] = userChoice;

                }
                if (userPos.equals("8")) {
                    arr[2][1] = userChoice;

                }
                if (userPos.equals("9")) {
                    arr[2][2] = userChoice;

                }
                break;
            }catch (IllegalArgumentException e){

                System.out.println("Enter a number in this range 1-9: ");
            }
        }  //End while loop

    }    //End of userTurn method

    /////////////////////////////////////////////////////

    public static void computerTurn(String [][] arr, String comChoice){

        Random random = new Random();
        String comPosition = null;

        String[] arrPositions = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        while (true) {
            int randomPos = random.nextInt(arrPositions.length);
            comPosition = arrPositions[randomPos];


            if (checkEmptyPos(arr, comPosition)) {


                if (comPosition.equals("1")) {
                    arr[0][0] = comChoice;

                } if (comPosition.equals("2")) {
                    arr[0][1] = comChoice;

                } if (comPosition.equals("3")) {
                    arr[0][2] = comChoice;

                } if (comPosition.equals("4")) {
                    arr[1][0] = comChoice;

                } if (comPosition.equals("5")) {
                    arr[1][1] = comChoice;

                } if (comPosition.equals("6")) {
                    arr[1][2] = comChoice;

                } if (comPosition.equals("7")) {
                    arr[2][0] = comChoice;

                } if (comPosition.equals("8")) {
                    arr[2][1] = comChoice;

                } if (comPosition.equals("9")) {
                    arr[2][2] = comChoice;

                }
                break;
            } //End first if


        } //End while loop


    }  //End computerTurn method


/////////////////////////////////////////////////////

    public static boolean checkEmptyPos(String [][] arr, String position){

        for(int i = 0; i < 3; i++){        //Outer loop for every row in array
            for(int j = 0; j < 3; j++){   //Inner loop for every colum in row in array

                if(arr[i][j].equals(position))   //Return true if this cell empty and not yet filled by x or o
                    return true;

            } //End inner loop


        } //End outer loop


        return false;        //If arr[i][j] not empty and already filled by either x or o

    } //End checkEmptyPos method

    /////////////////////////////////////////////////////


    public static boolean whoIsWinner(String[][] arr, String choice) {

        int numOfRows = 3;

        for (int w = 0; w < numOfRows; w++) {

            if ((arr[w][0] == choice && arr[w][1] == choice && arr[w][2] == choice) ||          //Check if all columns for each row have the same choice
                    (arr[0][w] == choice && arr[1][w] == choice && arr[2][w] == choice)) {   //Check if all rows for each colum have the same choice
                return true;
            }

        } //End for loop

        if ((arr[0][0] == choice && arr[1][1] == choice && arr[2][2] == choice) ||
                (arr[0][2] == choice && arr[2][2] == choice && arr[2][0] == choice)) {
            return true;
        }
        return false;
    } //End whoIsWinner method

    /////////////////////////////////////////////////////

    public static boolean checkDraw(String [][] arr){

        int rowNums = 3;
        int columns = 3;

        for (int i = 0; i < rowNums; i++) {
            for (int j = 0; j < columns; j++) {
              if(!arr[i][j].equalsIgnoreCase("X") && !arr[i][j].equalsIgnoreCase("O") )
               //The pos of array is filled with number , and the board isn’t full until now.
                       return false;
            } //End inner loop

        } //End outer loop



        return true;

    } //End checkDraw method

    /////////////////////////////////////////////////////


    public static void checkIfRounds (int user, int comp){

        if (user > comp)
            System.out.println(" You are the winner in the overall game :) ");

        else if(comp > user)
            System.out.println(" in the overall game. Better luck next time !");

        else
            System.out.println("This game ends with draw!");



    } //End checkIfRounds metho

    /////////////////////////////////////////////////////

    public static void clearGameBoard(String [][] array){

      String [][] emptyBoard = {
              { "1", "2", "3" } ,
              {"4", "5", "6"  },
              {"7", "8", "9"  }
      };

      for (int i = 0; i < 3; i++){
          for(int j = 0; j < 3; j++) {

             array[i][j] = emptyBoard[i][j];
          } //End inner lop

      } //End outer loop

    } //End clearGameBoard





} //End of class
