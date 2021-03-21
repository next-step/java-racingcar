package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final static String GET_CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
    private final static String GET_STEP_NUMBER = "시도할 회수는 몇 회 인가요?";
    private final static String GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    static Scanner scanner = new Scanner(System.in);

    public static int getStepNumber() {
        System.out.println(GET_STEP_NUMBER);
        return scanner.nextInt();
    }

    public static String getCarNames() {
        System.out.println(GET_CAR_NAMES);
        return scanner.nextLine();
    }

}
