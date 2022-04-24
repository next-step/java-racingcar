package racingcarwinner.Exception;

public class NoWinnerException extends RuntimeException{
    private static final String EXCEPTION_MESSAGE = "모든 자동차가 움직이지 못해 우승자를 뽑을 수 없습니다.";
    public NoWinnerException() {
        super(EXCEPTION_MESSAGE);
    }
}
