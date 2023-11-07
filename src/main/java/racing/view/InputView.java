package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String QUESTION_MESSAGE_OF_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_MESSAGE_OF_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount(){
        System.out.println(QUESTION_MESSAGE_OF_CAR_COUNT);
        return scanner.nextInt();
    }

    public static int inputTryCount(){
        System.out.println(QUESTION_MESSAGE_OF_TRY_COUNT);
        return scanner.nextInt();
    }
}
