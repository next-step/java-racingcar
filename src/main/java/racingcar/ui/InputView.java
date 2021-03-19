package racingcar.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import racingcar.util.UserInputValidator;

public class InputView {

  private final BufferedReader reader;
  private final UserInputValidator validator;

  public InputView(BufferedReader reader) {
    this.reader = reader;
    this.validator = new UserInputValidator();
  }

  public List<String> getNameOfCars() throws IOException {
    System.out.println("경주할 자동차의 이름을 입력해주세요(이름은 (,) 쉼표로 구분)");
    return validator.carNameValidation(reader.readLine());
  }

  public String getRound() throws IOException {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return validator.inputRoundValidation(reader.readLine());
  }
}
