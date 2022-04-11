package racingCar.view;

import java.util.List;
import racingCar.model.Car;
import racingCar.service.CarService;
import racingCar.strategy.CarMoveRandomStrategy;

public final class OutputTable {

  private OutputTable() {
  }

  private final static String INSERT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private final static String HOW_MANY_GAMES = "시도할 회수는 몇 회 인가요?";

  private final static String OUTPUT_RESULT = "결과: ";

  public static void main(String[] args) {
    CarService game = new CarService();
    System.out.println(INSERT_CAR_NAMES);
    List<Car> allCars = game.readyCars();
    System.out.println(HOW_MANY_GAMES);
    Integer rounds = game.gameRound();
    System.out.println(OUTPUT_RESULT);
    play(allCars, rounds);
  }

  public static void play(List<Car> allCars, Integer rounds) {
    for (int i = 0; i < rounds; i++) {
      for (Car car : allCars) {
        car.move(new CarMoveRandomStrategy());
        System.out.println(car);
      }
      System.out.println();
    }
  }
}
