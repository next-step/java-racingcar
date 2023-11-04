package racingcar;

import racingcar.domain.Car;
import racingcar.domain.GameNumber;
import racingcar.domain.RandomPicker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void game_자동차는_게임_진행_후_랜덤값이_GameNumber의_최소_이동값_이상이라면_전진한다() {
        // given
        RandomPicker customRandomPicker = () -> GameNumber.newNumber(GameNumber.MOVABLE_MIN_NUMBER);
        Car car = new Car(customRandomPicker);

        // when
        car.game();

        // then
        assertThat(car.grade()).isEqualTo(2);
    }

    @Test
    void game_자동차는_게임_진행_후_랜덤값이_GameNumber의_최소_이동값_미만이라면_전진하지_않는다() {
        // given
        int 움직일_수_없는_랜덤값 = GameNumber.MOVABLE_MIN_NUMBER - 1;
        RandomPicker customRandomPicker = () -> GameNumber.newNumber(움직일_수_없는_랜덤값);
        Car car = new Car(customRandomPicker);

        // when
        car.game();

        // then
        assertThat(car.grade()).isEqualTo(1);
    }
}
