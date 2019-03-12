package racing.domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    public void 자동차단일이동() {
        Car car = new Car();
        int moveDistance = car.move();
        assertThat(moveDistance).isLessThanOrEqualTo(1);
    }

    @Test
    public void 자동차여러번이동() {
        Car car = new Car();
        car.move();
        car.move();
        car.move();
        int moveDistance = car.move();
        assertThat(moveDistance).isLessThanOrEqualTo(4);
    }

    @Test
    public void 자동차가이번에움직였나() {
        Car car = new Car();
        assertThat(car.getMoveCount(1)).isFalse();
        assertThat(car.getMoveCount(4)).isTrue();
        assertThat(car.getMoveCount(7)).isTrue();
    }

    @Test
    public void 랜덤값가져오기() {
        Car car = new Car();
        assertThat(car.getRandomValue()).isLessThan(10);
        assertThat(car.getRandomValue()).isGreaterThanOrEqualTo(0);
    }


}