package racing;

public class InputFacadeView {

  private final InputView inputView;
  private final ResultView resultView;

  public InputFacadeView(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  public UserInput scanUserInput() {
    UserInput userInput = inputView.scanUserInput();
    resultView.printEmptyLine();
    return userInput;
  }

}
