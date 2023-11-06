package racingcar;

import racingcar.domain.Car;
import racingcar.domain.GameNumber;
import racingcar.domain.RandomPicker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void create_자동차_이름은_5자를_초과할_수_없다() {
        // given
        String invalidCarName = "invalid car name";
        RandomPicker customRandomPicker = () -> GameNumber.newNumber(GameNumber.MOVABLE_MIN_NUMBER);

        // when then
        assertThatThrownBy(() -> Car.create(invalidCarName, customRandomPicker))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void game_자동차는_게임_진행_후_랜덤값이_GameNumber의_최소_이동값_이상이라면_전진한다() {
        // given
        int defaultGrade = 1;
        String carName = "car";
        RandomPicker customRandomPicker = () -> GameNumber.newNumber(GameNumber.MOVABLE_MIN_NUMBER);
        Car car = Car.create(carName, customRandomPicker);

        // when
        car.game();

        // then
        assertThat(car.grade()).isEqualTo(defaultGrade + 1);
    }

    @Test
    void game_자동차는_게임_진행_후_랜덤값이_GameNumber의_최소_이동값_미만이라면_전진하지_않는다() {
        // given
        int defaultGrade = 1;
        String carName = "car";
        int 움직일_수_없는_랜덤값 = GameNumber.MOVABLE_MIN_NUMBER - 1;
        RandomPicker customRandomPicker = () -> GameNumber.newNumber(움직일_수_없는_랜덤값);
        Car car = Car.create(carName, customRandomPicker);

        // when
        car.game();

        // then
        assertThat(car.grade()).isEqualTo(defaultGrade);
    }
}
