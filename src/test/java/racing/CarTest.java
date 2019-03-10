package racing;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    public void 자동차이동() {
        Car car = new Car();
        car.move(5);
        assertThat(car.getMoveList().size()).isLessThanOrEqualTo(5);
        assertThat(car.getTotalDistance()).isLessThanOrEqualTo(5);
    }

    @Test
    public void 자동차가이번에움직였나() {
        Car car = new Car();
        assertThat(car.getMoveCount(1)).isEqualTo(0);
        assertThat(car.getMoveCount(4)).isEqualTo(1);
        assertThat(car.getMoveCount(7)).isEqualTo(1);
    }

    @Test
    public void 랜덤값가져오기() {
        Car car = new Car();
        assertThat(car.getRandomValue()).isLessThan(10);
        assertThat(car.getRandomValue()).isGreaterThanOrEqualTo(0);
    }


}