package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

  private Car car;

  @BeforeEach
  void before() {
    car = new Car("name");
  }

  @DisplayName("Car객체 생성 시 distance 초기값이 1인지 확인한다.")
  @Test
  void initDistanceTest() {
    assertThat(car.getDistance()).isEqualTo(1);
  }

  @DisplayName("Car객체 생성 시 이름이 제대로 할당되었는지 확인한다.")
  @Test
  void initNameTest() {
    assertThat(car.getName()).isEqualTo("name");
  }

  @DisplayName("Car name이 예외 인 경우를 확인")
  @ParameterizedTest
  @ValueSource(strings = {"AAAAAAA", ""})
  void carNameCheckExceptionTest(String carName) {
    assertThatThrownBy(() -> {
      new Car(carName);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("move 와 getDistance 가 잘 동작하는지 확인")
  @Test
  public void canMoveTest() {
    car.move(5);
    assertThat(car.getDistance()).isEqualTo(2);
  }

  @DisplayName("이동할 수 없는지 확인")
  @Test
  void cannotMoveTest() {
    car.move(1);
    assertThat(car.getDistance()).isEqualTo(1);
  }

}
