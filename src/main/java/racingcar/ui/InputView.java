package racingcar.ui;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NUMBER_GUIDE = "자동차 대수는 몇 대 인가요?";
    private static final String TRIAL_NUMBER_GUIDE = "시도할 회수는 몇 회 인가요?";

    public static int carNumber() {
        System.out.println(CAR_NUMBER_GUIDE);
        return scanner.nextInt();
    }

    public static int trialNumber() {
        System.out.println(TRIAL_NUMBER_GUIDE);
        return scanner.nextInt();
    }
}
