package study.racinggame.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private Car car;

  private static Stream<Arguments> provideGameStrategyForForward() {
    return Stream.of(
            Arguments.of((GameStrategy) () -> true, 1),
            Arguments.of((GameStrategy) () -> false, 0)
    );
  }

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
    car = new Car();
  }

  @Test
  @DisplayName("Car 객체 생성 테스트")
  public void car() {
    assertThat(car.distance()).isEqualTo(0);
  }

  @ParameterizedTest(name = "Car 객체 전진 테스트")
  @MethodSource("provideGameStrategyForForward")
  public void forward(GameStrategy racingStrategy, int expected) {
    car.forward(racingStrategy);
    assertThat(car.distance()).isEqualTo(expected);
  }

  @Test
  @DisplayName("car 3번 이동한 거리 출력 테스트")
  public void printDistance() {
    car.forward(() -> true);
    car.forward(() -> true);
    car.forward(() -> true);

    car.printDistance();
    assertEquals("---", outputStreamCaptor.toString().trim());
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }
}
