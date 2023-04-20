package study.step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.domain.racingGame.Car;

public class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car();
  }

  @DisplayName("차량 안 움직이는 지 태스트")
  @ParameterizedTest
  @CsvSource(value = {"1,0", "2,0", "3,0"})
  public void notMoveTest(int randomValue, int expected) {
    this.car.move(randomValue);
    assertThat(car.getTotalDistance()).isEqualTo(expected);
  }

  @DisplayName("차량 5글자거 넘 이름를 가지고 생성 테스트 에러")
  @Test
  public void createCarWithNameErrorTest() {
    String carName = "abcdefg";
    assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("차량 이름은 5글자를 넘길 수 없습니다.");
  }
}
