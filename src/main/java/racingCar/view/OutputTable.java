package racingCar.view;

import java.util.List;
import racingCar.model.Car;
import racingCar.service.CarService;
import racingCar.strategy.CarMoveRandomStrategy;

public final class OutputTable {

  private final static String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
  private final static String HOW_MANY_GAMES = "시도할 회수는 몇 회 인가요?";

  private final static String OUTPUT_RESULT = "결과: ";
  private final static String STEP = "-";

  public static void main(String[] args) {
    CarService game = new CarService();
    System.out.println(HOW_MANY_CARS);
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
        System.out.println(STEP.repeat(Math.max(0, car.position())));
      }
      System.out.println();
    }
  }
}
