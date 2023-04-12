package racing.controller.output;

import java.util.List;
import racing.controller.input.UserInput;
import racing.domain.Car;
import racing.domain.CarFactory;
import racing.util.RandomNumberGenerator;

public class ResultFacadeViewController {

  private final ResultView resultView;
  private final CarFactory carFactory;
  public ResultFacadeViewController(ResultView resultView, CarFactory carFactory) {
    this.resultView = resultView;
    this.carFactory = carFactory;
  }

  /**
   * 책임
   *  - 게임에 참가할 자동차 객체를 생성
   *  - 결과 view 를 제어하기 위한 책임을 갖는다.
   */
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
      car.move(RandomNumberGenerator.generate());
      resultView.printCarPosition(car);
    }
  }
}
