package racingcar.view;

import java.util.stream.Stream;

import static racingcar.domain.CarFactory.DELIMITER;
import static racingcar.domain.Name.MAX_LENGTH;

public class RetryView {
    private static final String RETRY_INPUT_NUMBER_MESSAGE = "1 이상의 숫자만 입력해 주세요.";
    private static final String RETRY_INPUT_NAME_MESSAGE = "유효한 이름을 입력해주세요.";

    private RetryView() {
    }

    public static String retryIfNotValidNames(View inputView) {
        String names = inputView.input();

        if (isNotValid(names)) {
            System.out.println(RETRY_INPUT_NAME_MESSAGE);
            return retryIfNotValidNames(inputView);
        }

        return names;
    }

    private static boolean isNotValid(String names) {
        return Stream.of(names.split(DELIMITER))
                .map(String::strip)
                .anyMatch(name -> name.length() > MAX_LENGTH);
    }

    public static int retryIfNotValidNumber(View inputView) {
        int number;

        try {
            number = Integer.parseInt(inputView.input());
        } catch (NumberFormatException e) {
            System.out.println(RETRY_INPUT_NUMBER_MESSAGE);
            return retryIfNotValidNumber(inputView);
        }

        if (isZeroOrNegative(number)) {
            System.out.println(RETRY_INPUT_NUMBER_MESSAGE);
            return retryIfNotValidNumber(inputView);
        }

        return number;
    }

    private static boolean isZeroOrNegative(int number) {
        return number <= 0;
    }
}
