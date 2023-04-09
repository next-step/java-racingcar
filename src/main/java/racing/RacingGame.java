package racing;


public class RacingGame {
  
  private static CarFactory carFactory;
  private static CarMoveCondition carMoveCondition;
  private static CarMoveController carMoveController;
  private static RandomNumberGenerator randomNumberGenerator;
  private static InputView inputView;
  private static ResultView resultView;
  private static InputFacadeView inputFacadeView;
  private static ResultFacadeView resultFacadeView;
  
  
  public static void setUp() {
    carMoveCondition = new CarMoveCondition();
    randomNumberGenerator = new RandomNumberGenerator();
    carMoveController = new CarMoveController(carMoveCondition, randomNumberGenerator);

    resultView = new ResultView();
    inputView = new InputView();
    inputFacadeView = new InputFacadeView(inputView, resultView);

    carFactory = new CarFactory();
    resultFacadeView = new ResultFacadeView(resultView, carFactory, carMoveController);
  }

  public static void main(String[] args) {
    setUp();

    UserInput userInput = inputFacadeView.scanUserInput();

    resultFacadeView.startGame(userInput);
  }

}
