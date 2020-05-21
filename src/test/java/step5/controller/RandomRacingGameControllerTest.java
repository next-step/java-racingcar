package step5.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step5.Exception.WinnerException;
import step5.domain.AlwaysMoveStrategy;
import step5.domain.Car;
import step5.domain.Racing;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomRacingGameControllerTest {

  static private RandomRacingGameController
                 controller = new RandomRacingGameController(AlwaysMoveStrategy.getInstance());

  @DisplayName("레이싱 컨트롤러로 경기 내용 및 결과를 조회")
  @ParameterizedTest
  @MethodSource("provideControllerAndRacingParameter")
  void 레이싱_컨트롤러_테스트 (
    RandomRacingGameController controller,
    String[] cars,
    int time,
    int expected
  ) throws WinnerException {
    Racing racing = controller.createRacing(cars, time);
    controller.printRacingResult(racing);
    Stream<Car> winners = controller.getRaceWinners(racing);
    assertThat(winners.count()).isEqualTo(expected);
  }

  static Stream<Arguments> provideControllerAndRacingParameter () {
    return Stream.of(
      Arguments.of(controller, "a,b".split(","), 10, 2),
      Arguments.of(controller, "a,b,c".split(","), 20, 3),
      Arguments.of(controller, "a,b,c,d".split(","), 30, 4)
    );
  }
}
