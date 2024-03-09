package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import testutils.IOTest;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
  private Car car;

  @BeforeEach
  void beforeEach() {
    this.car = new Car();
  }

  @Test
  void 초기_위치_값으로_생성() {
    Car car = new Car(10);
    assertThat(car.getLocation()).isEqualTo(10);
  }

  @Test
  void 입력이_4보다_크거나_같으면_전진() {
    car.moveConditionally(4);
    assertThat(car.getLocation()).isEqualTo(1);
  }

  @Test
  void 입력이_4보다_작으면_정지() {
    car.moveConditionally(3);
    assertThat(car.getLocation()).isEqualTo(0);
  }

  @Test
  void 현재_위치값_가져오기() {
    Car car = new Car(10);
    assertThat(car.getLocation()).isEqualTo(10);
  }
}
