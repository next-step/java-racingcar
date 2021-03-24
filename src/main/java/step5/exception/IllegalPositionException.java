package step5.exception;

public class IllegalPositionException extends RuntimeException{
  public IllegalPositionException(String message) {
    super(message);
  }
}
