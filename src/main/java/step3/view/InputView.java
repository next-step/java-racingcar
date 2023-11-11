package step3.view;

import java.util.Scanner;

public class InputView {
    protected static final Scanner scanner = new Scanner(System.in);
    protected static final String QUESTION_ABOUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    protected static final String QUESTION_ABOUT_ATTEMPT_COUNT = "시도할 회수는 몇 회 인가요?";
    
    private InputView() {}

    public static int inputCarCount() {
        System.out.println(QUESTION_ABOUT_CAR_COUNT);
        return scanner.nextInt();
    }

    public static int inputAttemptCount()  {
        System.out.println(QUESTION_ABOUT_ATTEMPT_COUNT);
        return scanner.nextInt();
    }

}
