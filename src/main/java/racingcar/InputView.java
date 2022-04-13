package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_COUNT_MESSAGE = "총 라운드 수를 입력하세요.";
    private final Scanner scanner = new Scanner(System.in);

    public int inputCarCount() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return scanner.nextInt();
    }

    public String[] inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return getCarNameArray(scanner.nextLine());
    }

    public String[] getCarNameArray(String inputString) {
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("Car names must not be null or empty");
        }
        String[] carNames = inputString.split(",");
        if (!validateCarNameLength(carNames)) {
            throw new IllegalArgumentException("The name of the car cannot exceed five characters");
        }
        return carNames;
    }

    private boolean validateCarNameLength(String[] carNames) {
        return Arrays.stream(carNames).allMatch(c -> c.length() < 5);
    }

    public int inputRoundCount() {
        System.out.println(INPUT_ROUND_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
