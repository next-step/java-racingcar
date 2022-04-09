package racingcar;

import java.util.Scanner;

public class ConsoleReader {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).";

    private static final String TRIAL_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    private int readNumber() {
        return scanner.nextInt();
    }

    private String readCarNames() {
        return scanner.nextLine();
    }

    public String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        return readCarNames();
    }

    public int inputTrialCount() {
        System.out.println(TRIAL_COUNT_MESSAGE);
        return readNumber();
    }


}
