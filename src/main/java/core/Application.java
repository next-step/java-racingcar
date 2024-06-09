package core;

import core.car.Car;
import core.car.CarImpl;
import core.car.CarInterface;
import core.user.UserImpl;
import core.user.UserInterface;
import core.util.Util;
import java.util.ArrayList;
import java.util.List;

public class Application {

  static Util util;
  public static void main(String[] args) {
    UserInterface ui = new UserImpl();
    util = new Util();
    List<String> carNames = ui.getCarNames();
    Integer gameTimes = ui.getGameTimes();
    List<Car> cars = new ArrayList<Car>();
    List<CarInterface> carImpls = new ArrayList<CarInterface>();
    Integer maxDistance = 0;
    for (String carName : carNames) {
      Car car = new Car(carName, 0);
      CarInterface carInterface = new CarImpl(car, util);
      cars.add(car);
      carImpls.add(carInterface);
    }

    System.out.println("실행 결과");
    for (int gameTime = 0; gameTime < gameTimes; ++gameTime) {
      for (CarInterface carImpl : carImpls) {
        Integer randomNum = carImpl.getRandomNum();
        carImpl.goForward(randomNum);
        String printStr = carImpl.getCarName() + " : " + carImpl.getDistanceByString();
        maxDistance = Math.max(maxDistance, carImpl.getDistanceByInteger());
        System.out.println(printStr);
      }
      System.out.println();
    }

    List<Car> winners = new ArrayList<Car>();
    for (Car car : cars) {
      if (car.getDistance() < maxDistance)
        continue;
      winners.add(car);
    }

    System.out.print("최종 우승자 : ");
    String result = Util.joinListWithComma(winners);
    System.out.println(result);
  }
}
