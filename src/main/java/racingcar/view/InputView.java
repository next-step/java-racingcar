package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final Integer CAR_NAME_LENGTH_BOUNDARY = 5;
    private static final String CAR_NAME_EXCEPTION_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";

    private final List<String> carNames;
    private final int tryCount;

    public InputView(List<String> carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public static InputView scan() {
        System.out.println(CAR_NAMES_QUESTION);
        Scanner scanner = new Scanner(System.in);
        List<String> carNames = Arrays.stream(scanner.nextLine().split(CAR_NAME_DELIMITER)).collect(toList());

        validate(carNames);

        System.out.println(TRY_COUNT_QUESTION);
        int tryCount = Integer.parseInt(scanner.nextLine());

        return new InputView(carNames, tryCount);
    }

    private static void validate(List<String> carNames) {
        boolean existsInvalidName = carNames.stream().anyMatch(carName -> carName.length() > CAR_NAME_LENGTH_BOUNDARY);
        if (existsInvalidName) {
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION_MESSAGE);
        }
    }

    public List<String> carNames() {
        return carNames;
    }

    public int tryCount() {
        return tryCount;
    }
}
