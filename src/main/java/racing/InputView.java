package racing;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static String[] getCarNames() {
        String carNamesInput = getCarNamesInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = splitAndValidate(carNamesInput);
        return carNames;
    }

    public static int getNumberOfLaps() {
        return getUserInputNumber("시도할 회수는 몇 회 인가요?");
    }

    private static int getUserInputNumber(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String getCarNamesInput(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String[] splitAndValidate(String carNames) {
        String[] splitCarNames = splitCarNames(carNames);
        for (String carName : splitCarNames) {
            validateCarName(carName);
        }

        return splitCarNames;
    }

    private static boolean validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        return true;
    }

    private static String[] splitCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .filter(InputView::validateCarName)
                .toArray(String[]::new);
    }
}
