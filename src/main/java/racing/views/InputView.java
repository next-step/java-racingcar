package racing.views;

import racing.data.Messages;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTryTimes() {
        while (true) {
            ResultView.println(Messages.ASK_TRY_TIMES);
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                ResultView.printTypeError();
            }
        }
    }

    public static String[] inputCarNames() {
        while (true) {
            ResultView.askCarNames();
            try {
                return scanner.next().split(",");
            } catch (Exception e) {
                ResultView.printTypeError();
            }
        }
    }

    public static String[] inputCarCounts() {
        while (true) {
            ResultView.askCarCounts();
            try {
                return scanner.next().split(",");
            } catch (Exception e) {
                ResultView.printTypeError();
            }
        }
    }
}
