package step3.view;

import java.util.Scanner;

public class InputView {
    private final static String GET_CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
    private final static String GET_STEP_NUMBER = "시도할 회수는 몇 회 인가요?";
    Scanner scanner = new Scanner(System.in);

    public int getCarNumber() {
        System.out.println(GET_CAR_NUMBER);
        return scanner.nextInt();
    }

    public int getStepNumber() {
        System.out.println(GET_STEP_NUMBER);
        return scanner.nextInt();
    }

}
