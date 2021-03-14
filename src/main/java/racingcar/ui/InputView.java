package racingcar.ui;

import java.io.BufferedReader;
import java.io.IOException;
<<<<<<< HEAD
import java.util.List;
import racingcar.util.UserInputValidator;
=======
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))

public class InputView {

  private final BufferedReader reader;
<<<<<<< HEAD
  private final UserInputValidator validator;

  public InputView(BufferedReader reader) {
    this.reader = reader;
    this.validator = new UserInputValidator();
  }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
  public String[] getNameOfCars() throws IOException {
=======
  public String[] getNumberOfCars() throws IOException {
>>>>>>> ae2d86ff (feat : InputView Validator 추가 및 OutputView 우승자 출력 로직 추가 기존 UserInputValidator.java 삭제)
=======
  public String[] getNameOfCars() throws IOException {
>>>>>>> a149dddf (refactor : 다른 클래스들의 변경 점에 따른 리팩토링 수행)
=======
  public List<String> getNameOfCars() throws IOException {
>>>>>>> 72a107e2 (refactor : User의 입력 값을 String[] -> List<String>으로 변경, sb.toString() 삭제)
    System.out.println("경주할 자동차의 이름을 입력해주세요(이름은 (,) 쉼표로 구분)");
    return validator.carNameValidation(reader.readLine());
=======

  public InputView(BufferedReader reader) {
    this.reader = reader;
  }

  public String getNumberOfCars() throws IOException {
    System.out.println("자동차 대수는 몇 대 인가요?");
    return validation(reader.readLine());
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  }

  public String getRound() throws IOException {
    System.out.println("시도할 회수는 몇 회 인가요?");
<<<<<<< HEAD
    return validator.inputRoundValidation(reader.readLine());
=======
    return validation(reader.readLine());
  }

  public String validation(String userInput) {
    if(!UserInputValidator.isNumeric(userInput)){
      throw new IllegalArgumentException("숫자만 입력하실 수 있습니다.");
    }
    return userInput;
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  }
}
