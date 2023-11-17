package racingcar.model;

import racingcar.common.utils.TextLimitSizeValidator;

public class Name {

        private static final int TEXT_LENGTH_LIMIT = 5;
        private final String value;

        public Name(String value) {
                if (isEmptyOrNull(value)) {
                        throw new IllegalArgumentException("한 글자 이상의 이름을 입력해주세요.");
                }
                this.value = value;
                validateTextLengthLimitOver();
        }

        public String value() {
                return this.value;
        }

        private void validateTextLengthLimitOver() {
                TextLimitSizeValidator.validateOverLimitSize(this.value, TEXT_LENGTH_LIMIT);
        }

        private boolean isEmptyOrNull(String text) {
                return text == null || text.isEmpty();
        }

}
