package racing.controller;


import racing.controller.input.InputFacadeViewController;
import racing.controller.input.InputView;
import racing.controller.output.ResultView;
import racing.controller.input.UserInput;
import racing.controller.output.ResultFacadeViewController;
import racing.domain.CarFactory;

public class RacingCarGameController {
  
  private static CarFactory carFactory;
  private static InputView inputView;
  private static ResultView resultView;
  private static InputFacadeViewController inputFacadeViewController;
  private static ResultFacadeViewController resultFacadeViewController;
  
  
  public static void setUp() {

    resultView = new ResultView();
    inputView = new InputView();
    inputFacadeViewController = new InputFacadeViewController(inputView, resultView);

    carFactory = new CarFactory();
    resultFacadeViewController = new ResultFacadeViewController(resultView, carFactory);
  }

  public static void main(String[] args) {
    setUp();

    // 입력 받는 Section 에 대한 제어를 InputFacadeViewController 에게 위임
    UserInput userInput = inputFacadeViewController.scanUserInput();

    // 출력 Section 에 대한 제어를 ResultFacadeViewController 에게 위임
    resultFacadeViewController.startGame(userInput);
  }

}
