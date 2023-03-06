package racingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("자동차 객체 이름 초기화 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni"})
    void carInitTest(String name) {
        // given
        Car car = new Car(name);

        // when
        // nothing

        // then
        assertThat(car.name).isEqualTo(name);
    }

    @DisplayName("자동차 객체 전진 테스트")
    @Test
    void carForwardTest() {
        // given
        Car car = new Car("test");

        // when
        car.forward();

        // then
        assertThat(car.position).isEqualTo(1);
    }

    @DisplayName("자동차 객체 현재 위치값 출력 테스트")
    @Test
    void carShowPositionTest() {
        // given
        Car car = new Car("test");

        // when
        car.forward();

        // then
        assertThatCode(car::showPosition).doesNotThrowAnyException();
    }

    @DisplayName("자동차 객체 위치값 비교(앞에 있는지) 테스트")
    @Test
    void carIsAheadOfTest() {
        // given
        Car car = new Car("test");

        // when
        car.forward();

        // then
        assertThat(car.isAheadOf(0)).isTrue();
    }

    @DisplayName("자동차 객체 위치값 비교(같은 위치인지) 테스트")
    @Test
    void carIsEqualOfTest() {
        // given
        Car car = new Car("test");

        // when
        car.forward();

        // then
        assertThat(car.isEqualOf(1)).isTrue();
    }
}
