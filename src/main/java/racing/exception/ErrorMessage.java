package racing.exception;

public abstract class ErrorMessage {
  private final String message;
  protected ErrorMessage(String message){
    this.message = message;
  }
  public String getMessage(){
    return message;
  }
}
