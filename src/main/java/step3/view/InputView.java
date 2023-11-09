package step3.view;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static int askNumberOfCars() {
        return askNumericInput("자동차 대수는 몇 대 인가요?");
    }

    public static int askNumberOfAttempts() {
        return askNumericInput("시도할 회수는 몇 회 인가요?");
    }

    private static int askNumericInput(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }

}
