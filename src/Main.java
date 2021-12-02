import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Example array: [1, 4, 10]
        //Between 1 and 4 there are 2 numbers
        //Between 4 and 10 there are 5 numbers

        //Right answer: 2 (Between 1 and 4)

        Scanner scanner = new Scanner(System.in);

        String userInput = "";

        while (!userInput.equals("e")) {
            System.out.println("Input numbers separated by comma (,)");
            System.out.println("Input 'e' to exit.");

            userInput = scanner.nextLine();
            userInput = userInput.replaceAll(" ", "");

            String[] stringArray = userInput.split(",");
            int[] intArray = new int[stringArray.length];

            boolean error = false;

            for (int i = 0; i < stringArray.length; i++) {
                try {
                    intArray[i] = Integer.parseInt(stringArray[i]);
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Could not parse value: " + stringArray[i] + " to Integer");
                    error = true;
                }
            }

            if (!error) {
                System.out.println(getSmallestAmountOfNumbersFromConsole(intArray));
            }

            System.out.println();
        }
    }

    /**
     * Interaktiivinen funktio, joka saa numerot käyttäjältä konsolin kautta ja antaa paremmat kuvaukset vastauksissa.
     * @param array
     * @return
     */
    public static String getSmallestAmountOfNumbersFromConsole(int[] array) {
        Arrays.sort(array);

        if (array.length == 1) {
            return "Only one number in array: " + array[0];
        }

        if (array.length == 2) {
            return "Only two numbers in array. Smallest number between is: " + (array[1] - array[0] - 1) + ", [" + array[0] + ", " + array[1] + "]";
        }

        int smallestAmountOfNumbers = Integer.MAX_VALUE;
        int leftNumber = 0;
        int rightNumber = 0;
        int right = 1;

        for (int left = 0; (left+1) < array.length; left++) {
            right = left+1;

            int amountOfNumbers = array[right] - array[left] - 1;
            if (amountOfNumbers < smallestAmountOfNumbers && amountOfNumbers >= 0) {
                smallestAmountOfNumbers = amountOfNumbers;
                leftNumber = array[left];
                rightNumber = array[right];
            }
        }

        if (smallestAmountOfNumbers == Integer.MAX_VALUE) {
            return "Could not find smallest number between given numbers.";
        }

        return "Result: " + smallestAmountOfNumbers + ", [" + leftNumber + ", " + rightNumber + "]";
    }



    /**
     * Tehtävänannon mukainen funktio, joka palauttaa joko numerovastauksen tai null-arvon jos annetuttujen numeroiden väliä ei löydy.
     * @param array
     * @return
     */
    public static Integer getSmallestAmountOfNumbersFromTests(int[] array) {
        if (array != null && array.length > 2) {

            Arrays.sort(array);

            int smallestAmountOfNumbers = Integer.MAX_VALUE;

            for (int left = 0; (left+1) < array.length; left++) {
                int right = left+1;

                int amountOfNumbers = array[right] - array[left] - 1;
                if (amountOfNumbers < smallestAmountOfNumbers && amountOfNumbers >= 0) {
                    smallestAmountOfNumbers = amountOfNumbers;
                }
            }

            if (smallestAmountOfNumbers < Integer.MAX_VALUE) {
                return smallestAmountOfNumbers;
            }
        }

        return null;
    }
}
