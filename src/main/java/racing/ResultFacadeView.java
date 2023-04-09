package racing;

import java.util.List;

public class ResultFacadeView {

  private final ResultView resultView;
  private final CarFactory carFactory;
  private final CarMoveController carMoveController;

  public ResultFacadeView(ResultView resultView, CarFactory carFactory, CarMoveController carMoveController) {
    this.resultView = resultView;
    this.carFactory = carFactory;
    this.carMoveController = carMoveController;
  }

  public void startGame(UserInput userInput) {
    List<Car> cars = carFactory.createCars(userInput.numberOfCars());

    resultView.printResultTitle();
    for (int i = 0; i < userInput.numberOfMovements(); i++) {
      move(cars);
      resultView.printEmptyLine();
    }

  }

  private void move(List<Car> cars) {
    for (Car car : cars) {
      carMoveController.move(car);
      resultView.printCarPosition(car);
    }
  }
}
