package study.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racingcar.error.InvalidCarNameException;

public class CarTest {

  @DisplayName("이름이 null이거나 blank한 자동차는 생성할 수 없다.")
  @Test
  public void car_ThrowException_NameIsBlank() {
    assertThatThrownBy(() -> new Car(null)).isInstanceOf(InvalidCarNameException.class);
    assertThatThrownBy(() -> new Car("")).isInstanceOf(InvalidCarNameException.class);
  }

  @DisplayName("이름의 길이가 5자를 초과하는 자동차는 생성할 수 없다.")
  @Test
  public void car_ThrowException_NameLengthMoreThan5() {
    assertThatThrownBy(() -> new Car("123456")).isInstanceOf(InvalidCarNameException.class);
    assertThatThrownBy(() -> new Car("123 45")).isInstanceOf(InvalidCarNameException.class);
  }

  @DisplayName("생성 시 Position을 명시하지 않은 자동차는 기본 위치를 갖는다.")
  @Test
  public void car_HasDefaultPosition() {
    assertThat(new Car("pobi").isSamePosition(new Position())).isTrue();
  }

  @DisplayName("생성 시 Position을 명시한 자동차는 해당 위치를 갖는다.")
  @Test
  public void car_HasPosition() {
    assertThat(new Car("pobi", 4).isSamePosition(new Position(4))).isTrue();
  }

  @DisplayName("4미만의 RandomInt는 자동차를 정지시킨다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  public void move_Stop_RandomIntLessThan4(int input) {
    Car pobi = new Car("pobi");

    pobi.move(new RandomInt(input));

    assertThat(pobi.isSamePosition(new Position(0))).isTrue();
  }

  @DisplayName("4이상의 RandomInt는 자동차를 전진시킨다.")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  public void move_Forward_RandomIntMoreThan4(int input) {
    Car pobi = new Car("pobi");

    pobi.move(new RandomInt(input));

    assertThat(pobi.isSamePosition(new Position(1))).isTrue();
  }

  @DisplayName("자동차의 현재 위치와 같다면 True를 반환한다.")
  @Test
  public void isSamePosition_True() {
    Car pobi = new Car("pobi", 10);

    assertThat(pobi.isSamePosition(new Position(10))).isTrue();
  }

  @DisplayName("자동차의 현재 위치와 다르다면 False를 반환한다.")
  @Test
  public void isSamePosition_False() {
    Car pobi = new Car("pobi", 10);

    assertThat(pobi.isSamePosition(new Position(11))).isFalse();
  }

  @DisplayName("자동차의 현재 위치와 비교하여 최대값을 갖는 위치를 반환한다.")
  @Test
  public void getMaxPosition_MaxPosition() {
    Car car = new Car("pobi", 10);

    Position bigPosition = new Position(15);
    assertThat(car.getMaxPosition(bigPosition).equals(bigPosition)).isTrue();

    Position smallPosition = new Position(5);
    assertThat(car.getMaxPosition(smallPosition).equals(smallPosition)).isFalse();
  }
}
