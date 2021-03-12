package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
  private Car car;

  @BeforeEach
  void setup(){
    car = new Car();
  }

  @ParameterizedTest
  @DisplayName("4 이상의 값이 입력됐을 시 정상적으로 동작하는지 확인")
  @ValueSource(ints = {4,5,6,7,8,9})
  void moveOkTest(int randomValue){
    assertThat(car.move(randomValue)).isEqualTo(1);
  }

  @ParameterizedTest
  @DisplayName("3 이하의 값이 입력됐을 시 작동하지 않는지 확인")
  @ValueSource(ints = {0,1,2,3})
  void moveFailTest(int randomValue) {
    assertThat(car.move(randomValue)).isEqualTo(0);
  }

}
