package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_FOR_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE_FOR_OVER_CAR_NAME_LENGTH = "자동차의 이름은 5자를 넘을 수 없습니다.";
    private static final String ERROR_MESSAGE_FOR_BLANK_CAR_NAME = "자동차의 이름은 1자 이상이여야 합니다.";

    private static final Scanner scanner = new Scanner(System.in);

    public String[] inputCarNames() {
        System.out.println(QUESTION_FOR_CAR_NAMES);

        String[] carNames = scanner.nextLine().split(DELIMITER);
        for (String carName : carNames) {
            checkCarName(carName);
        }
        return carNames;
    }

    private void checkCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_OVER_CAR_NAME_LENGTH);
        }
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_BLANK_CAR_NAME);
        }
    }

    public int inputAttemptCount() {
        System.out.println(QUESTION_FOR_ATTEMPT_COUNT);
        return scanner.nextInt();
    }
}
