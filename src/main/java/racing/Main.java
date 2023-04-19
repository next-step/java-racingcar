package racing;

import racing.race.Cars;
import racing.view.InputView;

public class Main {

  public static void main(String[] args) {
    System.out.println("자동차 대수는 몇 대 인가요?");
    int carNumber = InputView.getValue();
    Cars cars = new Cars(carNumber);

    System.out.println("시도할 회수는 몇 회 인가요?");
    int tryNumber = InputView.getValue();

    System.out.println("\n실행 결과");
    cars.race(cars.getGameCar(), tryNumber);
  }

}
