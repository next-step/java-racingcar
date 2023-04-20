package study.step4;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.racingGame.Car;

public class CarTest {


  @DisplayName("차량 5글자거 넘 이름를 가지고 생성 테스트 에러")
  @Test
  public void createCarWithNameTest() {
    String carName = "abcds";
    assertThat(new Car(carName)).isInstanceOf(Car.class);
  }

  @DisplayName("차량 5글자거 넘 이름를 가지고 생성 테스트 에러")
  @Test
  public void createCarWithNameErrorTest() {
    String carName = "abcdefg";
    assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("차량 이름은 5글자를 넘길 수 없습니다.");
  }
}
