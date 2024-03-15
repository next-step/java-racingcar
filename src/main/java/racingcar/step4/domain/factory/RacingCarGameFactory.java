package racingcar.step4.domain.factory;

import racingcar.step4.domain.Car;
import racingcar.step4.domain.RacingCarGame;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameFactory {

  public static final String NUMBER_OR_ROUND_IS_INCORRECT = "레이싱 횟수 올바르지 않습니다. input: %s";
  public static final String NUMBER_OR_CARS_IS_INCORRECT = "레이싱에 참여한 자동차 갯수가 올바르지 않습니다. 자동차 갯수: %s";

  public static List<RacingCarGame> of(int rounds, List<Car> cars) {
    validateNumberOfRounds(rounds);
    validateNumberOfCars(cars.size());

    List<RacingCarGame> racingCarGames = new ArrayList<>();
    for (int round = 1; round <= rounds; round++) {
      racingCarGames.add(RacingCarGame.generate(round, cars));
    }
    return racingCarGames;
  }

  private static void validateNumberOfRounds(int rounds) {
    if (rounds <= 0) {
      throw new IllegalArgumentException(String.format(NUMBER_OR_ROUND_IS_INCORRECT, rounds));
    }
  }

  private static void validateNumberOfCars(int cars) {
    if (cars <= 0) {
      throw new IllegalArgumentException(String.format(NUMBER_OR_CARS_IS_INCORRECT, cars));
    }
  }
}
