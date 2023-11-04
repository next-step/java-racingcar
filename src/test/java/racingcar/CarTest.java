package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void game_자동차는_게임_진행_후_랜덤값이_4이상이라면_전진한다() {
        // given
        RandomPicker customRandomPicker = () -> 4;
        Car car = new Car(customRandomPicker);

        // when
        car.game();

        // then
        assertThat(car.grade()).isEqualTo(2);
    }

    @Test
    void game_자동차는_게임_진행_후_랜덤값이_4미만이라면_전진하지_않는다() {
        // given
        RandomPicker customRandomPicker = () -> 1;
        Car car = new Car(customRandomPicker);

        // when
        car.game();

        // then
        assertThat(car.grade()).isEqualTo(1);
    }
}
