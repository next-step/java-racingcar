package racing_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import racing_game.core.Positive;
import racing_game.core.Result;

public class InputView {

  private String ment;
  private BufferedReader reader;
  private String value;

  private InputView(String ment, BufferedReader reader) {
    this.ment = ment;
    this.reader = reader;
  }

  public static InputView create(String ment, BufferedReader reader) {
    return new InputView(ment, reader);
  }

  public Positive getNumberInput() throws IOException {
    Result result = receive();
    while (Result.SUCCESS != result) {
      alertWrong();
      result = receive();
    }
    return Positive.of(value);
  }

  private Result receive() throws IOException {
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

  private void alertWrong() {
    System.out.println("잘못된 입력입니다.");
  }
}
