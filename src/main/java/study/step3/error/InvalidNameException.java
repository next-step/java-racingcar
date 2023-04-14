package study.step3.error;

public class InvalidNameException extends RuntimeException{

  public InvalidNameException(String message) {
    super(message);
  }
}
