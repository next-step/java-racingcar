package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차를 생성할 때 이동 위치의 기본 값을 0으로 설정한다.")
    @Test
    void createCar() {
        // given
        Car car = new Car();

        // when
        int currentPosition = car.getCurrentPosition();

        // then
        assertThat(currentPosition).isEqualTo(0);
    }

    @DisplayName("자동차를 생성할 때 이름을 부여한다.")
    @Test
    void createCarWithName() {
        // given
        String name = "abcde";
        Car car = new Car(name);

        // when
        String carName = car.getCarName();

        // then
        assertThat(carName).isEqualTo("abcde");
    }

    @DisplayName("자동차 생성 시 인자로 받는 이름이 5글자를 초과하면 예외를 던진다.")
    @Test
    void createCarWhenNameIsOverFiveChar() {
        // given
        String name = "abcdef";

        // when & then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차 생성시 인자로 받는 이름이 빈 문자열이면 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNameIsNone(String name) {
        // when & then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 빈 문자열이 될 수 없습니다.");
    }

    @DisplayName("자동차의 엑셀을 밟는 힘이 4이상이면 앞으로 이동한다.")
    @ParameterizedTest
    @CsvSource({"1,0", "3,0", "4,1", "9,1"})
    void moveForward(int power, int expectedPosition) {
        // given
        Car car = new Car();
        car.moveForward(power);

        // when
        int realPosition = car.getCurrentPosition();

        // then
        assertThat(realPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("자동차의 엑셀을 밟는 힘이 0~9의 범위를 넘어서면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void moveForwardWhenOverAndUnderPower(int power) {
        // given
        Car car = new Car();

        // when & then
        assertThatThrownBy(() -> car.moveForward(power))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("엑셀의 작동 범위를 벗어납니다.");
    }

    @DisplayName("인자로 받은 수와 자신의 이동위치를 비교해 더 큰 값을 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,5", "3,5", "6,6", "7,7"})
    void comparePosition(int position, int expectedResult) {
        // given
        Car hong = new Car("hong", 5);

        // when
        int realResult = hong.comparePosition(position);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }

    @DisplayName("인자로 받은 최대 이동 값이 자신의 이동 위치가 같으면 true, 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"5,true", "6,false"})
    void isMaxPosition(int max, boolean expectedResult) {
        // given
        Car hong = new Car("hong", 5);

        // when
        boolean maxPosition = hong.isMaxPosition(max);

        // then
        assertThat(maxPosition).isEqualTo(expectedResult);
    }
}