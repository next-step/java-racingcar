package core;

import core.car.Car;
import core.car.CarInterface;
import core.game.GameInterface;
import core.user.UserInterface;
import core.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Application {

  static Util util;
  static AppConfig appConfig;
  static CarInterface carImpl;
  static UserInterface userImpl;
  static GameInterface gameImpl;

  public static void main(String[] args) {
    util = new Util();
    appConfig = new AppConfig(util);
    carImpl = appConfig.carInterface();
    userImpl = appConfig.userInterface();
    gameImpl = appConfig.gameInterface(carImpl);

    appStart();
  }

  private static void appStart() {
    List<Car> cars = makeCars(carImpl, userImpl);
    Integer gameTimes = userImpl.getGameTimes();

    System.out.println("실행 결과");
    implGames(gameTimes, cars);

    List<Car> winners = getWinners(cars);
    printWinners(winners);
  }

  private static void implGames(Integer gameTimes, List<Car> cars) {
    IntStream.range(0, gameTimes).mapToObj(gameTime -> gameImpl.createGame(cars)).forEach(game -> {
      gameImpl.runGame(game);
      System.out.println();
    });
  }

  private static List<Car> getWinners(List<Car> cars) {
    Integer maxDistance = -1;
    List<Car> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.getDistance().equals(maxDistance)) {
        winners.add(car);
      }
      if (car.getDistance() > maxDistance) {
        winners.clear();
        winners.add(car);
        maxDistance = car.getDistance();
      }
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
