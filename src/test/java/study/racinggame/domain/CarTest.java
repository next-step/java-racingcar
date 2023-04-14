package study.racinggame.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private Car car;

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
    car = new Car("oneny");
  }

  @Test
  @DisplayName("Car 객체 생성 테스트")
  public void car() {
    assertThat(car.distance()).isEqualTo(0);
    assertThat(car.name()).isEqualTo("oneny");
  }

  @Test
  @DisplayName("Car 객체 전진 테스트")
  public void forward() {
    car.forward(new RacingGameStrategy());
    car.forward(new RacingGameStrategy());
    car.forward(new RacingGameStrategy());

    assertThat(car.distance()).isBetween(0, 3);
  }

  @Test
  @DisplayName("car 3번 이동한 거리 출력 테스트")
  public void printDistance() {
    car.forward(() -> true);
    car.forward(() -> true);
    car.forward(() -> true);

    assertThat(car.distance()).isEqualTo(3);
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }
}
