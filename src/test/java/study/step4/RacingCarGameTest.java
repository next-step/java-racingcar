package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.step4.domain.Car;
import racingcar.step4.domain.RacingCarGame;
import racingcar.step4.domain.factory.CarFactory;
import racingcar.step4.domain.factory.RacingCarGameFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

  @ParameterizedTest
  @CsvSource(value = {"pobi:1:1", "a,b,c,d,e:5:5", "a,b,c,d:10:10"}, delimiter = ':')
  @DisplayName("자동차 경주 게임 시도 횟수만큼 게임 결과가 쌓이는지 테스트")
  void racingCarGameTest(String input, int rounds, int expected) {
    List<Car> cars = CarFactory.of(input);
    List<RacingCarGame> racingCarGames = RacingCarGameFactory.of(rounds, cars);;
    assertThat(racingCarGames).hasSize(expected);
  }
}
