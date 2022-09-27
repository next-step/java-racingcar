package step3.util;

import java.util.Random;
import java.util.Scanner;

public class InputUtil {

    public static int getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getRandomNumberBetweenZeroAndNine() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
