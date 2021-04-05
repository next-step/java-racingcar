package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  @DisplayName("자동차의 위치 입력")
  @Test
  void carInitPositionTest() {
    // given
    int position = 2;

    // when
    Car car = new Car(position);

    // then
    assertThat(car.curPosition()).isEqualTo(2);
  }

  @DisplayName("자동차의 위치 이동")
  @Test
  void carMove() {
    // given
    int position = 2;

    // when
    Car car = new Car();
    car.move(position);

    // then
    assertThat(car.curPosition()).isEqualTo(2);
  }

  @DisplayName("랜덤값을 구하고 4 이상일 경우 이동")
  @Test
  void carRandomMove() {
    // given
    int randomNumber = RandomNumber.generator();

    // when
    Car car = new Car();
    car.move(randomNumber);

    // then
    assertThat(car.curPosition()).isEqualTo(randomNumber);
  }

  @DisplayName("위치가 4 이상일 경우 이동가능한지")
  @Test
  void carPositionNumberIsMove() {
    // given
    int position = 5;

    // when
    Car car = new Car();

    // then
    assertThat(car.isMove(position)).isTrue();
  }

  @DisplayName("위치가 4 미만일 경우 이동 실패하는지 테스트")
  @Test
  void carMoveFail() {
    // given
    int position = 4;

    // when
    Car car = new Car();

    // then
    assertThat(car.isMove(position)).isFalse();
  }

}
