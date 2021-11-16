package racingcar.utils;

import java.text.MessageFormat;

public interface StringLengthValidator {

    static String validUnderMaxLength(String text, int maxLength) {
        if (text.length() > maxLength) {
            throw new IllegalArgumentException(
                MessageFormat.format("글자 길이는 {0}자를 초과할 수 없습니다.", maxLength));
        }
        return text;
    }

}
