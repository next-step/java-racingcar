package racingCar;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private final Scanner SCANNER = new Scanner(System.in);
    private final String PRINT_HOW_MANY_CAR_PARTICIPATE = "자동차 대수는 몇 대인가요?";
    private final String PRINT_HOW_MANY_TRY = "시도할 회수는 몇 회인가요?";
    private final String PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_BETWEEN_TWO_AND_NINE = "2 ~ 9 사이의 양수를 입력해주세요.";
    private final String PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_BETWEEN_ONE_AND_NINE = "1 ~ 9 사이의 양수를 입력해주세요.";
    private final String PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_VALID_NUMBER_BETWEEN_TWO_AND_NINE = "2 ~ 9 사이의 유효한 숫자를 입력 해주세요.";
    private final String PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_VALID_NUMBER_BETWEEN_ONE_AND_NINE = "1 ~ 9 사이의 유효한 숫자를 입력 해주세요.";
    public int receiveCarCount() {
        System.out.println(PRINT_HOW_MANY_CAR_PARTICIPATE);

        while (true) {
            try {
                int carCount = SCANNER.nextInt();
                validateCarCount(carCount);
                System.out.println(carCount);
                return carCount;
            } catch (NumberFormatException e) {
                System.out.println(PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_VALID_NUMBER_BETWEEN_TWO_AND_NINE);
            }
        }
    }

    public int receiveRaceCount() {
        System.out.println(PRINT_HOW_MANY_TRY);

        while (true) {
            try {
                int raceCount = SCANNER.nextInt();
                validateRaceCount(raceCount);
                System.out.println(raceCount);
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

    private void validateCarCount(int carCount) {
        if (carCount <= 2) {
            throw new NumberFormatException(PRINT_NUMBER_FORMAT_EXCEPTION_PLEASE_INPUT_BETWEEN_TWO_AND_NINE);
        }
    }
}
