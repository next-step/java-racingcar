package study.step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step4.model.car.Car;

public class CarTest {


  @DisplayName("자동차 이름 추가 테스트")
  @Test
  public void carNameTest() {

    List<String> carNames = Arrays.asList("car1", "car2", "car3");

    for (String carName : carNames) {

      Car car = new Car(carName);
      assertThat(car.getName()).isEqualTo(carName);
    }
  }

  @DisplayName("자동차 이름 길이 제한 테스트")
  @Test
  public void carNameLenghthTest() {

    final int carNameMaxLenth = 5;

    List<String> carNames = Arrays.asList("car12", "car123", "car1234");

    for (String carName : carNames) {

      if (carName.length() > carNameMaxLenth) {
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
      } else {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
      }
    }
  }

}
