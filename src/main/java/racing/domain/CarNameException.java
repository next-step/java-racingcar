package racing.domain;

public class CarNameException extends RuntimeException {

    private static final String MESSAGE = "자동차 이름의 길이는 최소 한 글자, 최대 다섯 글자까지 허용됩니다.";

    public CarNameException() {
        super(MESSAGE);
    }
}
