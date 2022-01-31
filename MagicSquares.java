// Import modules.
import java.lang.NumberFormatException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/** Copyright (c) 2022 Mel Aguoth All rights reserved.
 * This generates, authenticates, and displays 3 by 3 magic squares.
 *
 * @author  Mel Aguoth
 * @version 11.0.13
 * @since 2022-01-26
 */

final class MagicSquares {
  
  public static void printMagicSquare(final int[] outputSquare) {

    // Format and display the magic squares.
    System.out.println("\n*****");
    for (int counter = 0; counter < outputSquare.length; ++counter) {
      if (counter == 3 || counter == 6) {
        System.out.println();
        System.out.print(outputSquare[counter] + " ");
      } else {
        System.out.print(outputSquare[counter] + " ");
      }
    }
    System.out.println("\n*****");
  }

  public static boolean magicCheck(final int[] intArray) {

    // If the array isn't a valid 9 element array, return false.
    if (intArray.length != 9) {
      return false;
    }
    
    // If the the array has repeating numbers, return false.
    for (int outerCounter = 0; outerCounter < intArray.length; ++outerCounter) {
      for (int innerCounter = 0; innerCounter < intArray.length; ++innerCounter) {
        if (outerCounter == innerCounter) {
          continue;
        } else if (intArray[outerCounter] == intArray[innerCounter]) {
          return false;
        }
      }
    }

    // If the horizontal sums aren't 15, return false.
    for (int horizontalCounter = 0; horizontalCounter < 6; horizontalCounter += 3) {
      if (intArray[horizontalCounter] + intArray[horizontalCounter + 1]
          + intArray[horizontalCounter + 2] != 15) {
        return false;
      }
    }

    // If the vertical sums aren't 15, return false.
    for (int verticalCounter = 0; verticalCounter < intArray.length / 3; ++verticalCounter) {
      if (intArray[verticalCounter] + intArray[verticalCounter + 3]
          + intArray[verticalCounter + 6] != 15) {
        return false;
      }
    }
    
    // If the main diagonal sums aren't 15, return false.
    if (intArray[0] + intArray[4] + intArray[8] != 15 || intArray[2] + intArray[4]
        + intArray[6] != 15) {
      return false;

    // If the array is a magic square, return true.
    } else {
      return true;
    }
  }

  public static void magicSquares(int[] magicSquareArray, int[] extraArray, int wizardNum) {

    // Generate a magic square.
    for (int magicCounter = 0; magicCounter < magicSquareArray.length; ++magicCounter) {
      if (extraArray[magicCounter] == 0) {
        extraArray[magicCounter] = 1;
        magicSquareArray[magicCounter] = wizardNum + 1;

        // Recurse until the magic square array is full.
        if (wizardNum < magicSquareArray.length - 1) {
          magicSquares(magicSquareArray, extraArray, wizardNum + 1);

        /* When full, check if the magic square array is a genuine magic square,
         * and if so, print it to the user. */
        } else if (magicCheck(magicSquareArray)) {
          printMagicSquare(magicSquareArray);
        }

        // Reset the extra array.
        extraArray[magicCounter] = 0;
      }
    }
  }

  public static void main(String[] args) {

    // Declare the arrays.
    int[] intArray = new int[9];
    int[] freeSpaceArray = new int[intArray.length];
 
    // Introduce the program.
    System.out.print("This program displays all possible magic squares with a magic order of 3."
        + " In other words, it shows all the 3 by 3 magic squares whose vertical, horizontal,"
        + " and main diagonal sums add to 15." + "\n");

    // Call magicSquares.
    System.out.print("\n" + "Here are all the possible order 3 magic squares: " + "\n");
    magicSquares(intArray, freeSpaceArray, 0);
  }
}
