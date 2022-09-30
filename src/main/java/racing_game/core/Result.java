package racing_game.core;

public enum Result {
  SUCCESS,
  FAIL;

  public static Result of(boolean value) {
    return value ? SUCCESS : FAIL;
  }

  public boolean isSuccess() {
    return SUCCESS == this;
  }

  public boolean isFail() {
    return FAIL == this;
  }
}
