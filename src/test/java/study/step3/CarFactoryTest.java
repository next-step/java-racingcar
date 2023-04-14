package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.domain.Car;
import study.step3.factory.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

  @DisplayName("입력받은 이름배열 순서에 맞게 이름을 갖는 자동차를 생성한다.")
  @Test
  public void create_carArr_nameOfCars() {
    String[] names = new String[]{"a","b","c"};

    List<Car> cars = CarFactory.createCars(names);

    assertThat(cars.size()).isEqualTo(names.length);
    for (int i = 0; i < names.length; i++) {
      assertThat(cars.get(i).getName()).isEqualTo(names[i]);
    }
  }
}
