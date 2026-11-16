package racingcar.view;

import java.util.regex.Pattern;

public class InputValidator {

    // 입력 검증 테스트위해 클래스 분리
    // 기존에는 InputView 에서 private 으로 validate 가 존재했지만, 테스트를 위해서 클래스 분리

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final String INVALID_NUMBER_MESSAGE = "숫자가 아닌 값이 포함되어 있습니다.";

    public static void validate(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }
}
