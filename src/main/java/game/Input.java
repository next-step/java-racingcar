package game;

import java.util.Scanner;

public class Input {

    public static int inputPositiveNumber() {
        try {
            Scanner sc = new Scanner(System.in);
            int result = sc.nextInt();
            checkPositiveNumber(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static void checkPositiveNumber(int result) {
        if (result < 0) {
            throw new RuntimeException();
        }
    }
}
