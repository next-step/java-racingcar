package racingcar.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @Test
    void play_호출시_move가_true면_distance가_증가한다() {
        car = new Car(() -> true);
        car.play();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void play_호출시_move가_false면_distance가_증가하지_않는다() {
        car = new Car(() -> false);
        car.play();
        assertThat(car.getDistance()).isEqualTo(0);
    }
}