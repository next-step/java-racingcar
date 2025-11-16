package racingcar;

import java.util.Scanner;

public class InputView {
    static int readCount(String x, Scanner scanner) {
        System.out.println(x);
        return scanner.nextInt();
    }
}
