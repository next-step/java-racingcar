package study.racing.common;

import study.racing.exception.Exception;
import study.racing.validation.Validation;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Common {

    private static final Random random = new Random();

    private static final int RANDOM_MAX_NUMBER = 10;

    private static final Scanner scanner = new Scanner(System.in);

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public static int createRandomNumber(){
        return random.nextInt(RANDOM_MAX_NUMBER);
    }

    public static int inputValueWithMessage(String message) {
        printMessage(message);
        int number = 0;

        try {
            number =  scanner.nextInt();
        }catch (InputMismatchException ie){
            Exception.InputMismatchException(Message.MSG_ERROR_VALUE_TYPE);
        }

        return number;
    }

    public static void printMessage(String text) {
        System.out.println(text);
    }

    public static void printNewLine() {
        System.out.print("\n");
    }

    public static String inputCarsNameWithMessage(String message) {
        printMessage(message);
        return scanner.nextLine();
    }

    public static String[] splitCarsName(String carsName) {
        return carsName.split(",");
    }
}