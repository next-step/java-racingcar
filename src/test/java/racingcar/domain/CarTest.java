package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"p", "pobii"})
    void Car생성할때_성공(String name) {
        // when
        final Car car = Car.create(name);

        // then
        assertThat(car.getName().getValue()).isEqualTo(name);
        assertThat(car.getPosition().getValue()).isZero();
    }

    @Test
    void 비었거나null인이름일때_생성실패_RuntimeException발생() {
        // given
        final String name1 = "";
        final String name2 = null;

        // when & then
        assertThatThrownBy(() -> Car.create(name1)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> Car.create(name2)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 정해진길이보다긴이름일때_생성실패_RuntimeException발생() {
        // given
        final String name = "aaaaaa";

        // when & then
        assertThatThrownBy(() -> Car.create(name)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 이동할때_position증가성공() {
        // given
        final Car car = Car.create("pobi");
        final int beforePosition = car.getPosition().getValue();

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition().getValue()).isEqualTo(beforePosition + 1);
    }
}