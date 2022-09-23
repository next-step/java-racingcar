package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.validator.NameValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?\n";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String RETRY_INPUT_NUMBER_MESSAGE = "1 이상의 숫자만 입력해 주세요.";
    private static final String RETRY_INPUT_NAME_MESSAGE = "유효한 이름을 입력해주세요.";


    private InputView() {
    }

    public static RacingRequest input() {
        String carNames = inputCarNames();
        int tryCount = inputTryCount();

        return new RacingRequest(carNames, tryCount);
    }

    private static String inputCarNames() {
        String names = inputWithText(INPUT_CAR_NAMES_MESSAGE);

        if (isNotValid(names)) {
            System.out.println(RETRY_INPUT_NAME_MESSAGE);
            return inputCarNames();
        }

        return names;
    }

    private static boolean isNotValid(String names) {
        return Stream.of(Cars.splitName(names))
                .anyMatch(NameValidator::isNotValid);
    }

    private static int inputTryCount() {
        int input = Integer.parseInt(inputWithText(INPUT_TRY_COUNT_MESSAGE));
        if (isZeroOrNegative(input)) {
            System.out.println(RETRY_INPUT_NUMBER_MESSAGE);
            return inputTryCount();
        }

        return input;
    }

    private static boolean isZeroOrNegative(int number) {
        return number <= 0;
    }

    private static String inputWithText(String inputMessage) {
        System.out.print(inputMessage);

        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
