package study.racinggame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

  private Car car;

  @BeforeEach
  public void setUp() {
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
    car.forward(() -> true);
    car.forward(() -> true);
    car.forward(() -> true);

    assertThat(car.distance()).isEqualTo(3);
  }

  @Test
  @DisplayName("Car 객체들 간 같은 거리 확인 테스트")
  public void isSamesDistance() {
    Car otherCar = new Car("twony", 2);

    car.forward(() -> true);
    car.forward(() -> true);

    assertTrue(car.isSameDistance(otherCar));
  }
}
