package racing_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import racing_game.core.Parsable;

public class InputView<T extends Parsable<T>> {

  private final BufferedReader reader;

  private InputView(BufferedReader reader) {
    this.reader = reader;
  }

  public static InputView create(BufferedReader reader) {
    return new InputView(reader);
  }

  public T fromInput(String ment, T target) throws IOException {
    String read = receive(ment, target);
    while (!target.canParse(read)) {
      wrongAlert();
      read = receive(ment, target);
    }
    return target.parse(read);
  }

  private String receive(String ment, T target) throws IOException {
    System.out.println(ment);
    return reader.readLine();
  }

  private void wrongAlert() {
    System.out.println("잘못된 입력입니다.");
  }
}
