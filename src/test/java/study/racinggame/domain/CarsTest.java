package study.racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class CarsTest {

  private List<Car> cars;

  private static Stream<Arguments> provideGameStrategyForForwardCars() {
    return Stream.of(
            Arguments.of((GameStrategy) () -> true, 1),
            Arguments.of((GameStrategy) () -> false, 0)
    );
  }

  @BeforeEach
  public void setUp() {
    cars = new ArrayList<>();
  }

  @Test
  @DisplayName("Cars 객체 크기 확인 테스트")
  public void cars() {
    cars.add(new Car());
    cars.add(new Car());
    cars.add(new Car());

    assertThat(cars).hasSize(3);
  }

  @ParameterizedTest
  @MethodSource("provideGameStrategyForForwardCars")
  public void forwardCars(GameStrategy gameStrategy, int expected) {
    for (Car car : cars) {
      car.forward(gameStrategy);
      assertThat(car.distance()).isEqualTo(expected);
    }
  }
}
