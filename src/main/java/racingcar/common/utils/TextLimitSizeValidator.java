package racingcar.common.utils;

public class TextLimitSizeValidator {

        private TextLimitSizeValidator() {
        }

        public static void validateOverLimitSize(String text, int limitSize) {
                if (text.length() > limitSize) {
                        throw new IllegalArgumentException(text + "는" + limitSize + "자 이하만 입력가능합니다.");
                }
        }
}
