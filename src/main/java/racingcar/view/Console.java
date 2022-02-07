package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.common.RacingCarException;

public class Console {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final int CAR_NAME_MAX = 5;
    private static final String DELIMETER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private Console() {

    }

    public static List<String> setRacingCarNames() {
        System.out.println(INPUT_CAR_NAME);

        List<String> carNames = Arrays.asList(scanner.nextLine().split(DELIMETER));

        validateCarNameEmpty(carNames);

        for (String carName : carNames) {
            validateCarNameLength(carName);
        }

        return carNames;
    }

    public static int setTryCount() {
        System.out.println(INPUT_TRY_COUNT);

        return Integer.parseInt(scanner.nextLine());
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_MAX) {
            throw new IllegalArgumentException(RacingCarException.CAR_NAME_INVALID);
        }
    }

    private static void validateCarNameEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(RacingCarException.CAR_NAME_EMPTY);
        }
    }
}
