package step3.domain;

public class ValidationCarName {

    private static final int CAR_NAME_LENGTH_POLICY = 5;
    private static final String CAR_NAME_LIMIT = "자동차의 이름은 5글자를 초과할 수 없습니다.";

    public static void carNameInvalidException(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_POLICY) {
            throw new IllegalArgumentException(CAR_NAME_LIMIT);
        }
    }

}
