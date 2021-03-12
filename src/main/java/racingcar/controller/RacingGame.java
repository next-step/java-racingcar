package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.CarNameException;
import racingcar.model.Car;
import racingcar.view.ResultView;

public class RacingGame {

  private static final int MAX_CAR_NAME_LENGTH = 5;
  public List<Car> cars = new ArrayList<>();

  public void readyGame(String inputName) {
    String[] names = inputName.split(",");

    for (int i = 0; i < names.length; i++) {
      validateName(names[i]);
      cars.add(new Car(names[i]));
    }
  }

  public void run(int attempt) {
    Movement move = new Movement();
    System.out.println("\n실행 결과");

    for (int i = 0; i < attempt; i++) {
      move.moveCars(cars);
      ResultView.showRacingResult(cars);
    }

    ResultView.showWinnerName(cars);
  }

  public void validateName(String name) {
    isMaxLength(name);
    isEmpty(name);
  }

  private void isMaxLength(String name) {
    if (name.length() > MAX_CAR_NAME_LENGTH) {
      throw new CarNameException("자동차 이름은 " + MAX_CAR_NAME_LENGTH + "자를 초과할 수 없습니다.");
    }
  }

  private void isEmpty(String name) {
    if ("".equals(name)) {
      throw new CarNameException("자동차 이름을 입력하세요.");
    }
  }
}
