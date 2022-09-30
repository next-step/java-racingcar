package racing_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import racing_game.core.Parsable;
import racing_game.core.Result;

public class InputView<T extends Parsable<T>> {

  private final BufferedReader reader;
  private String value;

  private InputView(BufferedReader reader) {
    this.reader = reader;
  }

  public static InputView create(BufferedReader reader) {
    return new InputView(reader);
  }

  public T fromInput(String ment, T target) throws IOException {
    Result result = receive(ment, target);
    while (result.isFail()) {
      wrongAlert();
      result = receive(ment, target);
    }
    return target.parse(value);
  }

  private Result receive(String ment, T target) throws IOException {
    System.out.println(ment);
    String readValue = reader.readLine();
    if (target.canParse(readValue)) {
      this.value = readValue;
      return Result.SUCCESS;
    }
    return Result.FAIL;
  }

  private void wrongAlert() {
    System.out.println("잘못된 입력입니다.");
  }
}
