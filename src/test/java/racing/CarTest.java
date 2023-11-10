package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    @DisplayName("4미만의 숫자를 주면 거리가 이동하지 않는다.")
    void 자동차이동테스트_4미만(int number) {
        // given 상황을 가정
        Car car = new Car();

        // when
        car.move(number);

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상의 숫자를 주면 거리가 1 증가한다.")
    void 자동차이동테스트_4이상(int number) {
        // given
        Car car = new Car();

        // when
        car.move(number);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("자동차 이동 후 이동 거리 확인 테스트")
    @Test
    void 자동차이동거리테스트() {
        // given
        Car car = new Car();

        // when
        car.move(1);
        car.move(5);
        car.move(5);

        // then
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @DisplayName("자동차 이름이 5자 이하일 경우 에러를 발생시키지 않는다.")
    @Test
    void 자동차이름테스트_5자이하() {
        // given, when
        Car car = new Car("name");

        // then
        assertThat(car.getName()).isEqualTo("name");
    }

    @DisplayName("자동차 이름이 5자 초과일 경우 에러를 발생시킨다.")
    @Test
    void 자동차이름테스트_5자초과() {
        assertThatThrownBy(() -> {
            new Car("testName");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
