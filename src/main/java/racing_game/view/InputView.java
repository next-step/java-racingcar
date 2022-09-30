package racing_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import racing_game.core.Positive;
import racing_game.core.Result;

public class InputView {

  private final BufferedReader reader;
  private String value;

  private InputView(BufferedReader reader) {
    this.reader = reader;
  }

  public static InputView create(BufferedReader reader) {
    return new InputView(reader);
  }

  public Positive getNumberInput(String ment) throws IOException {
    Result result = receive(ment);
    while (result.isFail()) {
      wrongAlert();
      result = receive(ment);
    }
    return Positive.of(value);
  }

  private Result receive(String ment) throws IOException {
    System.out.println(ment);
    String readValue = reader.readLine();
    if (isPositiveFormat(readValue)) {
      this.value = readValue;
      return Result.SUCCESS;
    }
    return Result.FAIL;
  }

  private boolean isPositiveFormat(String value) {
    try {
      Positive.of(value);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  private void wrongAlert() {
    System.out.println("잘못된 입력입니다.");
  }
}
