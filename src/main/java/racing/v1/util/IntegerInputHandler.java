package racing.v1.util;

import java.util.Scanner;

public class IntegerInputHandler {
    static Scanner scanner = new Scanner(System.in);

    public static String scan(){
        return scanner.nextLine();
    }

    public static boolean validate(String input) {
        int inputNum = 0;
        try {
            inputNum = Integer.parseInt(input);
        } catch (NumberFormatException e){
            return false;
        }
        return inputNum > 0;
    }
}
