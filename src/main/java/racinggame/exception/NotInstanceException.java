package racinggame.exception;

public class NotInstanceException extends RuntimeException{

    private static final String NOT_CREATE_INSTANCE_MESSAGE = "인스턴스로 생성할 수 없습니다.";

    public NotInstanceException() {
        super(NOT_CREATE_INSTANCE_MESSAGE);
    }
}
