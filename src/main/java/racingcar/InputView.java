package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_ROUND_NUMBER = "시도할 회수는 몇 회 인가요?";

    private static final String ERR_NEGATIVE_NUMBER = "Negative numbers are not allowed.";
    private static final String ERR_NAME_LENGTH = "Names longer than 5 characters are not allowed.";
    private static final String NAME_DELIMITER = ",";
    private static final int NAME_MAX_LENGTH = 5;


    public List<String> inputCarNameList() {
        System.out.println(QUESTION_CAR_NAMES);

        List<String> carNames = Arrays.asList(scanner.nextLine().split(NAME_DELIMITER));

        validateCarNameList(carNames);
        return carNames;
    }

    public int inputRoundNumber() {
        System.out.println(QUESTION_ROUND_NUMBER);

        int roundNumber = scanner.nextInt();

        validateRoundNumber(roundNumber);
        return roundNumber;
    }

    private void validateCarNameList(List<String> names) {
        for (String name : names) {
            validateCarName(name);
        }
    }

    private void validateCarName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new RuntimeException(ERR_NAME_LENGTH);
        }
    }

    private void validateRoundNumber(int roundNumber) {
        if (roundNumber < 0) {
            throw new RuntimeException(ERR_NEGATIVE_NUMBER);
        }
    }
}
