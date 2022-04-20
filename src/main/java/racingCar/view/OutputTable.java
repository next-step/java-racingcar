package racingCar.view;

import java.util.Comparator;
import java.util.List;
import racingCar.model.Car;
import racingCar.model.RacingCarHistory;
import racingCar.service.GameService;

public final class OutputTable {

  private static final String WHAT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String HOW_MANY_GAMES = "시도할 회수는 몇 회 인가요?";
  private static final String OUTPUT_RESULT = "결과: ";
  private static final String WINNER_TEXT_PRINT = "가 최종 우승했습니다.";

  private OutputTable() {
  }

  public static void main(String[] args) {
    GameService game = new GameService();
    System.out.println(WHAT_CAR_NAMES);
    List<Car> allCars = game.readyCars();
    System.out.println(HOW_MANY_GAMES);
    Integer rounds = game.gameRound();
    System.out.println(OUTPUT_RESULT);
    List<RacingCarHistory> racingHistories = game.play(allCars, rounds);
    historyPrint(allCars, racingHistories);
    List<Car> gameResult = game.gameResult(racingHistories, rounds);
    String winners = game.findWinners(gameResult);
    System.out.println(winners + WINNER_TEXT_PRINT);
  }

  private static void historyPrint(List<Car> allCars, List<RacingCarHistory> racingHistories) {
    racingHistories.sort(Comparator.comparingInt(RacingCarHistory::round));
    for (int i = 0; i < racingHistories.size(); i++) {
      System.out.println(racingHistories.get(i));
      enter(i + 1, allCars.size());
    }
  }

  private static void enter(int index, int carSize) {
    if (index % carSize == 0) {
      System.out.println();
    }
  }

}
