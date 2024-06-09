package core;

import core.car.Car;
import core.car.CarInterface;
import core.user.UserInterface;
import core.util.Util;
import java.util.ArrayList;
import java.util.List;

public class Application {

  static Util util;
  static Integer maxDistance = 0;

  public static void main(String[] args) {
    util = new Util();
    AppConfig appConfig = new AppConfig(util);
    CarInterface carImpl = appConfig.carInterface();
    UserInterface userImpl = appConfig.userInterface();
    List<Car> cars = makeCars(carImpl, userImpl);
    Integer gameTimes = userImpl.getGameTimes();

    System.out.println("실행 결과");
    implGames(gameTimes, cars, carImpl);

    List<Car> winners = getWinners(cars);
    printWinners(winners);
  }

  private static void implGames(Integer gameTimes, List<Car> cars, CarInterface carImpl) {
    for (int gameTime = 0; gameTime < gameTimes; ++gameTime) {
      for (Car car : cars) {
        Integer randomNum = util.getRandomNumFromZero(10);
        carImpl.goForward(car, randomNum);
        String printStr = car.getName() + " : " + carImpl.getDistanceWithString(car);
        System.out.println(printStr);
        maxDistance = Math.max(maxDistance, car.getDistance());
      }
      System.out.println();
    }
  }

  private static List<Car> getWinners(List<Car> cars) {
    List<Car> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.getDistance() < maxDistance) {
        continue;
      }
      winners.add(car);
    }
    return winners;
  }

  private static void printWinners(List<Car> winners) {
    System.out.print("최종 우승자 : ");
    String result = Util.joinListWithComma(winners);
    System.out.println(result);
  }

  private static List<Car> makeCars(CarInterface carInterface, UserInterface userInterface) {
    List<Car> cars = new ArrayList<>();
    List<String> carNames = userInterface.getCarNames();
    for (String carName : carNames) {
      Car car = carInterface.createCar(carName, 0);
      cars.add(car);
    }

    return cars;
  }
}
