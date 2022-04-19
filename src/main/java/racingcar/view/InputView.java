package racingcar.view;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRIAL_NUMBER_GUIDE = "시도할 회수는 몇 회 인가요?";

    public static String carNames() {
        System.out.println(CAR_NAME_GUIDE);
        return scanner.nextLine();
    }

    public static int trialNumber() {
        System.out.println(TRIAL_NUMBER_GUIDE);
        return scanner.nextInt();
    }
}
