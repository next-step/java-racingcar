package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinnersTest {

  @ParameterizedTest(name = "우승자는 한 명이거나 여러 명일 수 있다.")
  @MethodSource("carsAndResults")
  void findWinners(Cars cars, Winners expectedResult) {
    Winners winners = Winners.findWinners(cars);
    assertThat(winners).isEqualTo(expectedResult);
  }

  static Stream<Arguments> carsAndResults() {
    return Stream.of(
        Arguments.of(new Cars(List.of(
                new Car("yeny", 3),
                new Car("yeeun", 2),
                new Car("pobi", 2),
                new Car("jason", 1),
                new Car("ydh", 0)
            )),
            new Winners(List.of(
                new Car("yeny", 3)
            ))
        ),
        Arguments.of(new Cars(List.of(
                new Car("yeny", 3),
                new Car("yeeun", 3),
                new Car("pobi", 2),
                new Car("jason", 1),
                new Car("ydh", 0)
            )),
            new Winners(List.of(
                new Car("yeny", 3),
                new Car("yeeun", 3)
            ))
        )
    );
  }
}
