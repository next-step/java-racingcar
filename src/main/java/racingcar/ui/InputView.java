package racingcar.ui;

import java.util.Scanner;

public class InputView {

    private static final String NAME_SPLIT_REGEX = ",";
    private static final String INPUT_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_GUIDE = "시도할 회수는 몇 회 인가요?";

    public static String[] inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_GUIDE);
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();
        return carNames.split(NAME_SPLIT_REGEX);
    }

    public static int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
