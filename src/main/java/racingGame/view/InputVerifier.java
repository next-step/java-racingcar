package racingGame.view;

import racingGame.exception.NegativeExceptionV1;

import java.util.regex.Pattern;

public class InputVerifier {
    private static final Pattern inputFilter = Pattern.compile("^([0-9]+)$");
    public static void validateInput(String carNum) {
        if (!inputFilter.matcher(carNum).matches()) {
            throw new NegativeExceptionV1("잘못된 문자를 입력했습니다.");
        }
    }
}
