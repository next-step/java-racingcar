package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    public void 조건을_만족할때_position_증가() {
        Car car = new Car();
        int num = RandomUtil.generateRandomValue(ForwardCondition.FORWARD_CONDITION_LOW_BOUND, ForwardCondition.FORWARD_CONDITION_HIGH_BOUND);
        car.forwardCarByCondition(num);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 조건을_만족하지_않을_때_포지션변화() {
        Car car = new Car();
        int num = RandomUtil.generateRandomValue(0, ForwardCondition.FORWARD_CONDITION_LOW_BOUND);
        car.forwardCarByCondition(num);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 조건을_만족하지_않을_때_포지션변화2() {
        Car car = new Car();
        int num = RandomUtil.generateRandomValue(ForwardCondition.FORWARD_CONDITION_HIGH_BOUND + 1, ForwardCondition.HIGHEST_BOUND + 1);
        car.forwardCarByCondition(num);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}