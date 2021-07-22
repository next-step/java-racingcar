package study.racing.common;

import java.util.Random;
import java.util.Scanner;

public class Common {

    private static final Random random = new Random();

    private static final int LIMIT_NUMBER = 4;

    private static final Scanner scanner = new Scanner(System.in);

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public static int createRandomNumber(){
        return random.nextInt(10);
    }

    public static Boolean checkMoveableCar(int targetNumber) {
        return targetNumber >= LIMIT_NUMBER;
    }

    public static void drawDisplay(int moveDistance) {
        StringBuffer carModel = new StringBuffer();

        for(int i = 0; i < moveDistance; i++){
            carModel.append("-");
        }

        //output => start|
        System.out.println(Message.MSG_RESULT_FORM + carModel);

    }

    public static String inputValueWithMessage(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}