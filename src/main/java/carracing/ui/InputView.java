package carracing.ui;

import carracing.domain.entity.Number;
import carracing.domain.entity.Round;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

  private static InputView instance;
  private static ResultView resultView;


  private Scanner scanner = new Scanner(System.in);


  private static final String CAR_QUESTION = "자동차 대수는 몇대 인가요?";
  private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";
  private static final String INPUT_MESSAGE = "잘못 입력 하셨습니다. 0 이상의 자연수를 입력해주세요";

  private static final int ZERO = 0;

  private InputView() {
    resultView = ResultView.getInstance();
  }

  public static InputView getInstance() {
    if (instance == null) {
      return new InputView();
    }
    return instance;
  }

  public Number inputNumberOfCar() {
    return new Number(inputOperation(CAR_QUESTION));
  }

  public Round inputTryCount() {
    return new Round(new Number(inputOperation(TRY_QUESTION)));
  }

  private int inputOperation(String question) {
    int count = ZERO;
    while (!isGreaterThanZero(count)) {
      resultView.printMessage(question);
      count = inputKeyboard();
    }
    return count;
  }

  private boolean isGreaterThanZero(int count) {
    return count > ZERO;
  }

  private int inputKeyboard() {
    int count = 0;
    try {
      count = scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println(INPUT_MESSAGE);
    }
    return count;
  }


}
