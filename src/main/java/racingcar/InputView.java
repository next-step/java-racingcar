package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_COUNT_MESSAGE = "총 라운드 수를 입력하세요.";
    private static final int MINIMUM_NAME_LENGTH = 5;
    private static final String CAR_NAME_EMPTY_ERROR_MESSAGE = "자동차 이름은 비어있을 수 없습니다.";
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 다섯 글자 이하여야 합니다.";
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
        validateEmptyInput(inputString);
        String[] carNames = inputString.split(",");
        validateNameLength(carNames);
        return carNames;
    }

    private void validateNameLength(String[] carNames) {
        if (!isValidNameLength(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateEmptyInput(String inputString) {
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR_MESSAGE);
        }
    }

    private boolean isValidNameLength(String[] carNames) {
        return Arrays.stream(carNames).allMatch(this::validateCarNameLength);
    }

    private boolean validateCarNameLength(String carName) {
        return carName.length() <= MINIMUM_NAME_LENGTH;
    }

    public int inputRoundCount() {
        System.out.println(INPUT_ROUND_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
