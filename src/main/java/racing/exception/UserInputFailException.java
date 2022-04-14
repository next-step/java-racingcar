package racing.exception;

public class UserInputFailException extends RuntimeException {

  private static final String USER_INPUT_FAIL_MESSAGE = "사용자 입력을 받는데 실패했습니다.";

  public UserInputFailException(Throwable cause) {
    super(USER_INPUT_FAIL_MESSAGE, cause);
  }
}
