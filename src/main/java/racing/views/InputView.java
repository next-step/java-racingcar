package racing.views;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount(String question) {
        while (true) {
            ResultView.println(question);
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
}
