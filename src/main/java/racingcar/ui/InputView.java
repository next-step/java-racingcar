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
    return validation(reader.readLine());
  }

  public String getRound() throws IOException {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return validation(reader.readLine());
  }

  public String validation(String userInput) {
    if(!UserInputValidator.isNumeric(userInput)){
      throw new IllegalArgumentException("숫자만 입력하실 수 있습니다.");
    }
    return userInput;
  }
}
