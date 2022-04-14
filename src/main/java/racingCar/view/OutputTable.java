package racingCar.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.model.Car;
import racingCar.model.RacingCarHistory;
import racingCar.service.CarService;
import racingCar.strategy.CarMoveRandomStrategy;

public final class OutputTable {

  private static final String WHAT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String HOW_MANY_GAMES = "시도할 회수는 몇 회 인가요?";
  private static final String OUTPUT_RESULT = "결과: ";
  private static final String STEP = "-";

  private OutputTable() {
  }

  public static void main(String[] args) {
    CarService game = new CarService();
    System.out.println(WHAT_CAR_NAMES);
    List<Car> allCars = game.readyCars();
    System.out.println(HOW_MANY_GAMES);
    Integer rounds = game.gameRound();
    System.out.println(OUTPUT_RESULT);
    List<RacingCarHistory> racingHistories = play(allCars, rounds);
    historyPrint(allCars, racingHistories);
  }

  private static void historyPrint(List<Car> allCars, List<RacingCarHistory> racingHistories) {
    racingHistories.sort(Comparator.comparingInt(RacingCarHistory::round));
    for (RacingCarHistory racingCarHistory : racingHistories) {
      System.out.println(racingCarHistory.car());
      enter(allCars, racingCarHistory);
    }
  }

  private static void enter(List<Car> allCars, RacingCarHistory racingCarHistory) {
    if (racingCarHistory.carIndex() == allCars.size()) {
      System.out.println();
    }
  }

  private static List<RacingCarHistory> play(List<Car> allCars, Integer rounds) {
    List<RacingCarHistory> printCars = new ArrayList<>();
    for (Car car : allCars) {
      for (int i = 0; i < rounds; i++) {
        car = car.move(new CarMoveRandomStrategy());
        printCars.add(new RacingCarHistory(i + 1, car, car.index()));
      }
    }
    return printCars;
  }
}
