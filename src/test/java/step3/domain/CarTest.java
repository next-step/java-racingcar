package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 자동차 생성, 이동 테스트
 */
class CarTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    void createdCar_ShouldNotNull() {
        // given
        Car car = Car.of();
        // when

        // then
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차의 이동 위치를 확인 테스트")
    @ParameterizedTest(name = "value 값이 {0} 인 경우 -> position 값 : {1}")
    @CsvSource(value = {"4, 2", "5, 2", "2, 1"})
    void move_CarPosition(int value, int position) {
        // given
        Car car = Car.of();
        // when
        car.move(value);
        // then
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차의 연속적인 이동 위치를 확인 테스트")
    @ParameterizedTest(name = "첫 번째 값: {0}, 두 번째 값: {1} -> position 값 : {2}")
    @CsvSource(value = {"4, 5, 3", "1, 2, 1", "6, 3, 2"})
    void moves_CarPosition(int first, int second, int position) {
        // given
        Car car = Car.of();
        // when
        car.move(first);
        car.move(second);
        // then
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
