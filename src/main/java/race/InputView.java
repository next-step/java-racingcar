package race;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner SCANNER = new Scanner(System.in);
    private final String PRINT_INPUT_CAR_NAME_TO_PARTICIPANT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String PRINT_HOW_MANY_TRY = "시도할 회수는 몇 회인가요?";
    private final String PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_BETWEEN_ONE_AND_NINE = "1 ~ 9 사이의 양수를 입력해주세요.";
    private final String PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_VALID_NUMBER_BETWEEN_ONE_AND_NINE = "1 ~ 9 사이의 유효한 숫자를 입력 해주세요.";
    private final String PRINT_CAR_NAME_LENGTH_SHOULD_BE_UNDER_SIX = "자동차 이름은 5자를 초과할 수 없습니다.";

    public List<String> receiveCarNames() {
        System.out.println(PRINT_INPUT_CAR_NAME_TO_PARTICIPANT);
        String carNamesString = SCANNER.next();
        List<String> carNames = List.of(carNamesString.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        carNames.stream().forEach(carName -> {
            validateCarNameLength(carName);
        });
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(PRINT_CAR_NAME_LENGTH_SHOULD_BE_UNDER_SIX);
        }
    }

    public int receiveRaceCount() {
        System.out.println(PRINT_HOW_MANY_TRY);

        while (true) {
            try {
                int raceCount = SCANNER.nextInt();
                validateRaceCount(raceCount);
                return raceCount;
            } catch (NumberFormatException e) {
                System.out.println(PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_VALID_NUMBER_BETWEEN_ONE_AND_NINE);
            }
        }
    }

    public void closeScanner() {
        if (SCANNER != null) {
            SCANNER.close();
        }
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount <= 1) {
            throw new NumberFormatException(PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_BETWEEN_ONE_AND_NINE);
        }
    }
}
