package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.entity.Car;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    @DisplayName("Random value가 0~9 사이의 값으로 생성된다.")
    public void randomValue_is_valid_whenBetweenZeroAndNine() {
        int actual = RacingGame.getRandomValue();
        assertThat(actual).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {RacingGame.MIN_MOVE_VALUE, RacingGame.MIN_MOVE_VALUE + 2})
    @DisplayName("Random value가 MIN_MOVE_VALUE 이상이면 전진 가능하다.")
    public void car_moves_whenValueIsOrMore(int input) {
        boolean actual = RacingGame.isMovable(input);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {RacingGame.MIN_MOVE_VALUE - 1, RacingGame.MIN_MOVE_VALUE - 2})
    @DisplayName("Random value가 MIN_MOVE_VALUE 미만이면 움직이지 않는다.")
    public void car_stays_whenValueIsLessThan_MinMoveValue(int input) {
        boolean actual = RacingGame.isMovable(input);
        assertThat(actual).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:3", "3:4"}, delimiter = ':')
    @DisplayName("Car 의 이동한 횟수에 맞춰 현재 위치가 반영된다.")
    public void print_car_currentPosition(int moveCount, int expected) {
        // given
        Car car = new Car();

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        // then
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }

}