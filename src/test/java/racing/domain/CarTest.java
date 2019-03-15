package racing.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 자동차단일이동() {
        Car car = new Car();
        boolean isMove = car.move();
        int moveDistance = car.getTotalDistance();

        if (isMove) {
            assertThat(moveDistance).isEqualTo(1);
        }
    }

    @Test
    public void 자동차여러번이동() {
        Car car = new Car();
        for (int i = 0; i < 4; i++) {
            car.move();
        }
        assertThat(car.getTotalDistance()).isLessThanOrEqualTo(4);
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