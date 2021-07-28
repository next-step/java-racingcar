package carracing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CarNameConsoleInput {

    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NULL_INPUT = "입력값은 null 일 수 없습니다";
    private static final String DELIMITER = ",";
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getCarNames() {
        return splitOrThrow(askCarNames());
    }

    private String askCarNames() {
        System.out.println(CAR_NAME_QUESTION);
        return scanner.nextLine();
    }

    private List<String> splitOrThrow(String carNames) {
        validateCarNames(carNames);
        return split(carNames);
    }

    private List<String> split(String carNames) {
        return Arrays.asList(carNames.split(DELIMITER));
    }

    private void validateCarNames(String number) {
        requireNonNull(number);
    }

    private void requireNonNull(String number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException(NULL_INPUT);
        }
    }

}
