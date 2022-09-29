package racing_game.view;

import java.io.BufferedReader;
import java.io.IOException;
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

  public Integer getNumberInput() throws IOException {
    Result result = receive();
    while (Result.SUCCESS != result) {
      alertWrong();
      result = receive();
    }
    return Integer.parseInt(value);
  }

  private Result receive() throws IOException {
    System.out.println(ment);
    String readValue = reader.readLine();
    if (isNumberFormat(readValue)) {
      this.value = readValue;
      return Result.SUCCESS;
    }
    return Result.FAIL;
  }

  private boolean isNumberFormat(String value) {
    try {
      Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  private void alertWrong() {
    System.out.println("잘못된 입력입니다.");
  }
}
