package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    public void 차_생성시_거리_기본값() {
        Car car = new Car();
        int movingDistance = car.getMovingDistance();
        assertThat(movingDistance).isEqualTo(0);

    }

    @Test
    public void 차_이동시_거리_증가() {
        Car car = new Car();
            car.moveCar();
            car.moveCar();
            int movingDistance = car.getMovingDistance();
            assertThat(movingDistance).isEqualTo(2);

    }


}