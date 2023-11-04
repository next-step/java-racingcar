package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void game_자동자는_게임_진행_후_상태를_알_수_있다() {
        Car car = new Car(new DefaultRandomPicker());

        CarStatus carStatus= car.game();

        assertThat(carStatus).isNotNull();
    }

    @Test
    void game_자동차는_게임_진행_후_랜덤값이_4이상이라면_전진한다() {
        // given
        RandomPicker customRandomPicker = () -> 4;
        Car car = new Car(customRandomPicker);

        // when
        CarStatus carStatus = car.game();

        // then
        assertThat(carStatus).isNotNull();
        assertThat(carStatus.grade()).isEqualTo(1);
    }

    @Test
    void game_자동차는_게임_진행_후_랜덤값이_4미만이라면_전진하지_않는다() {
        // given
        RandomPicker customRandomPicker = () -> 1;
        Car car = new Car(customRandomPicker);

        // when
        CarStatus carStatus = car.game();

        // then
        assertThat(carStatus).isNotNull();
        assertThat(carStatus.grade()).isEqualTo(0);
    }
}
