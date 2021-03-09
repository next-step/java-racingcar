package racingcar.ui;

import java.io.BufferedReader;
import java.io.IOException;

public class InputView {

  private final BufferedReader reader;

  public InputView(BufferedReader reader) {
    this.reader = reader;
  }

  public String getNumberOfCars() throws IOException {
    System.out.println("자동차 대수는 몇 대 인가요?");
    return reader.readLine();
  }

  public String getRound() throws IOException {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return reader.readLine();
  }
}
