package racingcar.model;

public class Constant {
    public static final String DELIMITER = ",";
    public static final String DASH = "-";

    public static class Exceptions {
        public static final String NOT_OVER_FIVE_CHARACTER = "자동차 이름은 5글자를 초과 할 수 없습니다.";
        public static final String DO_NOT_INPUT_NEGATIVE = "음수는 입력할 수 없습니다.";
        public static final String CAR_NAME_MUST_NOT_BE_NULL = "자동차 이름을 입력해 주세요";
    }

    public static class Car {
        public static final int MAX_BOUND = 10;
        public static final int RANDOM_NUMBER_LIMIT = 4;
    }

    public static class IntegerConstant {
        public static final int ZERO = 0;
        public static final int POSITIVE_ONE = 1;
        public static final int NEGATIVE_ONE = -1;
    }
}
