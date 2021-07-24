package racing.domain;

public class CarNameException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다. 게임을 다시 시작해주세요.";

    public CarNameException() {
        super(DEFAULT_MESSAGE);
    }

}
