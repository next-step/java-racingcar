package racing.exception;

public class CarNameLengthException extends RuntimeException {
    private static final String CAR_NAME_LENGTH_MESSAGE = "ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다(%s : %d자).";

    public CarNameLengthException(String carName) {
        super(String.format(CAR_NAME_LENGTH_MESSAGE, carName, carName.length()));
    }
}
