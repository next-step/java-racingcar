package racing.controller.input;

import racing.controller.output.ResultView;

public class InputFacadeViewController {

  private final InputView inputView;
  private final ResultView resultView;

  public InputFacadeViewController(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  /**
   * 책임
   *  - 사용자 입력을 받는다.
   *  - 사용자 입력을 받고, 한줄 띄우는 View 조정을 담당한다.
   */
  public UserInput scanUserInput() {
    UserInput userInput = inputView.scanUserInput();
    resultView.printEmptyLine();
    return userInput;
  }

}
