package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private static final String NUMBER_OF_CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String RACE_TRIAL_QUESTION = "시도할 회수는 몇 회 인가요?";

    public InputView() {

    }

    public static int getNumberOfCar() {
        System.out.println(NUMBER_OF_CAR_QUESTION);
        return scanner.nextInt();
    }

    public static int getRaceTrialCount() {
        System.out.println(RACE_TRIAL_QUESTION);
        return scanner.nextInt();
    }

}
