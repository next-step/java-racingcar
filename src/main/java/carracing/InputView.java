package carracing;

import java.util.Scanner;

public class InputView {
    public static final String QUESTION_TRY_TIMES = "시도할 횟수는 몇회인가요?";
    public static final String QUESTION_CAR_COUNTS = "자동차 대수는 몇대인가요?";
    Scanner scanner = new Scanner(System.in);

    public void printQuestionCarCount() {
        System.out.println(QUESTION_CAR_COUNTS);
    }

    public void printQuestionTryTimes() {
        System.out.println(QUESTION_TRY_TIMES);
    }

    public int carCounts() {
        return scanner.nextInt();
    }

    public int tryTimes() {
        return scanner.nextInt();
    }

}
