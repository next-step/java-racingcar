package calculator;

import java.util.Objects;

public class InputCheckor {
    private static final int MINIMUM_TEXT_LENGTH = 5;

    public static void checkInput(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException("입력이 존재하지 않습니다.");
        }
        if (text.length() < MINIMUM_TEXT_LENGTH) {
            throw new IllegalArgumentException("잘못된 입력 입니다. (최소 하나의 연산 기호와 2개의 숫자 입력값 필요.)");
        }
    }
}
