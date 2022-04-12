package racingcar;

import java.util.Random;
import java.util.Scanner;

public class InputView {
    public static int getCarNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (!isInputRange(number)) throw new RuntimeException("outOfRange");
        return number;
    }

    public static boolean isInputRange(int i) {
        return 0 < i && i < 10;
    }

}
