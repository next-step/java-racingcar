package carracing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("자동차의 위치가 자동차에 저장되어있어야 한다.")
    void carLocationTest() {

        // given
        Car car = new Car("car");

        // whe & then
        assertThat(car.position()).isEqualTo(new Position());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 10})
    @DisplayName("입력값이 4이상이 들어오면 자동차는 이동해야 한다.")
    void moveSuccessTest(int cmd) {

        // given
        Car car = new Car("car");

        // when
        Position result = car.move(cmd);

        // then
        assertThat(result).isEqualTo(new Position(1));
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("입력값이 3이하가 들어오면 자동차는 이동하지 않는다.")
    void moveFailTest(int cmd) {

        // given
        Car car = new Car("car");

        // when
        Position result = car.move(cmd);

        // then
        assertThat(result).isEqualTo(new Position(0));
    }

    @Test
    void carEqualsTest() {

        // given
        String input1 = "name";
        String input2 = "name";

        // when
        Car car1 = new Car(input1);
        Car car2 = new Car(input2);

        // then
        assertThat(car1).isEqualTo(car2);
    }

}