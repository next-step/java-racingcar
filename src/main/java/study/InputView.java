package study;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class InputView {
    private static final Scanner scanner = new Scanner(in);

    public static int readCarNumber() {
        out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        return carNumber;
    }

    public static int readTrialNumber() {
        out.println("시도할 회수는 몇 회 인가요?");
        int trialNumber = scanner.nextInt();
        return trialNumber;
    }
}
