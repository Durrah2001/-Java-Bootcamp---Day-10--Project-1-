package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String [] args){


        Scanner scanner = new Scanner(System.in);


        System.out.println("--------------------------------------------------");
        System.out.println(" * Welcome to the Calculator! * \n You can add, subtract, multiply, divide, and much more!");
        System.out.println("--------------------------------------------------");

        int firstNum = 0;
        int secNum = 0;

        boolean correctInput = false;

        while (!correctInput) {
            try {
                System.out.println("Enter the first number: ");
                firstNum = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter the second number: ");
                secNum = scanner.nextInt();
                scanner.nextLine();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Incorrect input! please enter integer number only.");
                scanner.nextLine();
            }
        }  //End while loop

            int lastResult = 0;
            StringBuilder allResult = new StringBuilder(" ");

            boolean computing = true;

            while (computing) {

                try{

                System.out.println("=== Calculator's Menu ===");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (x)");
                System.out.println("4. Division  (÷)");
                System.out.println("5. Modulus (%)");
                System.out.println("6. Minimum");
                System.out.println("7. Maximum");
                System.out.println("8. Average");
                System.out.println("9. Display Last Result in Calculator");
                System.out.println("10. Display a List Of All Results in Calculator");
                System.out.println("0. Exit \n");
                ;
                System.out.println("Enter the number (from menu above) of the operation you want to perform it: ");

                int userChoice = scanner.nextInt();
                scanner.nextLine();

                switch (userChoice) {

                    case 1:
                        lastResult = applyOperation(firstNum, secNum, userChoice);
                        System.out.println(firstNum + " + " + secNum + " = " + lastResult + "\n");
                        allResult.append(", ").append(lastResult);
                        break;

                    case 2:
                        lastResult = applyOperation(firstNum, secNum, userChoice);
                        System.out.println(firstNum + " - " + secNum + " = " + lastResult + "\n");
                        allResult.append(", ").append(lastResult);
                        break;

                    case 3:
                        lastResult = applyOperation(firstNum, secNum, userChoice);
                        System.out.println(firstNum + " x " + secNum + " = " + lastResult + "\n");
                        allResult.append(", ").append(lastResult);
                        break;

                    case 4:
                        lastResult = applyOperation(firstNum, secNum, userChoice);
                        System.out.println(firstNum + " ÷ " + secNum + " = " + lastResult + "\n");
                        allResult.append(", ").append(lastResult);
                        break;

                    case 5:
                        lastResult = applyOperation(firstNum, secNum, userChoice);
                        System.out.println(firstNum + " % " + secNum + " = " + lastResult + "\n");
                        allResult.append(", ").append(lastResult);
                        break;


                    case 6:
                        lastResult = Math.min(firstNum, secNum);
                        System.out.println("The minimum number between " + firstNum + ", " + secNum + " = " + lastResult + "\n");
                        allResult.append(", ").append(lastResult);
                        break;

                    case 7:
                        lastResult = Math.max(firstNum, secNum);
                        System.out.println("The maximum number between " + firstNum + ", " + secNum + " = " + lastResult + "\n");
                        allResult.append(", ").append(lastResult);
                        break;

                    case 8:
                        lastResult = (int) computeAvg(firstNum, secNum);
                        System.out.println("The average of " + firstNum + " and " + secNum + " = " + lastResult + "\n");
                        allResult.append(", ").append(lastResult);
                        break;

                    case 9:
                        System.out.println("The last result in the calculator = " + lastResult + "\n");
                        break;

                    case 10:
                        System.out.println("The all results in the calculator: " + allResult + "\n");
                        break;

                    case 0:
                        System.out.println("You are exited from the calculator...Goodbye !" + "\n");
                        computing = false;
                        break;

                    default:
                        System.out.println("Incorrect input! enter a number in this range(0-10): " + "\n");
                        break;

                } //End switch

            }catch (InputMismatchException e){
                System.out.println("Enter an integer number in this range (0-10) : !");
                return;

            }

            } //End while loop



    } //End main method

    ///////////////////////////////////////////////////////////////////

    public static int applyOperation(int first, int second, int choice){

        int resultAdd = 0;
        int resultSub = 0;
        int resultMultiply = 0;
        int resultDivide = 0;
        int resultModule = 0;


        if(choice == 1) {
            resultAdd = first + second;
            return resultAdd;
        }

         if(choice == 2) {
            resultSub = first - second;
            return resultSub;
        }

        if(choice == 3) {
            resultMultiply = first * second;
            return resultMultiply;
        }

         if(choice == 4) {
             resultDivide = first / second;
             return resultDivide;
         }

        if(choice == 5){
            resultModule = first % second;
            return resultModule;
        }

        return 0;
    } //End applyOperation method

///////////////////////////////////////////////////////////////////

    public static double computeAvg(int first, int second){

        double avg = 0;

        int sum = first + second;

        avg = (double) sum / 2;

        return avg;

    }  // End computeAvg method




    ///////////////////////////////////////////////////////////////////



} //End class
