package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.move.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.util.Constants.START_IDX;

/**
 * 자동차 생성, 이동 테스트
 */
class CarTest {

    // 자동차 생성 시 움직임 전략을 설정
    private MoveStrategy getMoveStrategy(boolean flag) {
        return () -> flag;
    }

    @DisplayName("자동차 생성 테스트")
    @Test
    void createdCar_ShouldNotNull() {
        // given
        Car car = new Car("0");
        // when

        // then
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차의 이동하는지 확인하는 테스트")
    @ParameterizedTest(name = "{0} 설정 시 -> position 값 : {1}")
    @CsvSource(value = {"true, 1", "false, 0"})
    void move_CarPosition(boolean flag, int position) {
        // given
        Car car = new Car("1", getMoveStrategy(flag));
        // when
        car.move();
        // then
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차의 연속적인 이동 위치를 확인 테스트")
    @ParameterizedTest(name = "자동차 이동 전략: {0}, position 값 : {1}")
    @CsvSource(value = {"true, 2", "false, 0"})
    void moves_CarPosition(boolean firstFlag, int position) {
        // given
        Car car = new Car("1", getMoveStrategy(firstFlag));
        // when
        car.move();
        car.move();
        // then
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
