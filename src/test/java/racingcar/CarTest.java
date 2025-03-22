package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("랜덤 입력값이 4 이상이면 전진한다.")
    @Test
    void moveTest() {
        //given
        Car car = new Car("name");
        int randomInt = 4;

        //when
        car.moveOrStop(randomInt);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 입력값이 4보다 작으면 멈춘다.")
    @Test
    void stopTest() {
        //given
        Car car = new Car("name");
        int randomInt = 3;

        //when
        car.moveOrStop(randomInt);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("차에 주어지는 랜덤 입력값은 0 부터 9사이인 정수가 아니면 에러를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void withOutOfRangeThrowError(int randomInt) {
        //given
        Car car = new Car("name");

        //when & then
        Assertions.assertThatThrownBy(() -> car.moveOrStop(randomInt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 부터 9 사이의 정수값만 입력 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과하는 경우 에러를 던진다.")
    void carNameTest() {
        //given
        String longName = "5자 초과하는 이름";

        //when & then
        Assertions.assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 이름이 유효하지 않습니다 [name: ");
    }
}