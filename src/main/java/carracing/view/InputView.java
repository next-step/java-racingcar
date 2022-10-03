package carracing.view;

import java.util.Scanner;

public class InputView {
    public static final String QUESTION_TRY_TIMES = "시도할 횟수는 몇회인가요?";
    public static final String QUESTION_CAR_COUNTS = "자동차 대수는 몇대인가요?";
    Scanner scanner = new Scanner(System.in);

    public int scanTimes() {
        printQuestionCarCount();
        return tryTimes();
    }

    public int scanCounts() {
        printQuestionTryTimes();
        return carCounts();
    }

    private void printQuestionCarCount() {
        System.out.println(QUESTION_CAR_COUNTS);
    }

    private void printQuestionTryTimes() {
        System.out.println(QUESTION_TRY_TIMES);
    }

    private int carCounts() {
        return scanner.nextInt();
    }

    private int tryTimes() {
        return scanner.nextInt();
    }
}
