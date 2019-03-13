package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    static final int MOVEABLE_RANDOMNUM = 4;
    static final int NONE_MOVEABLE_RANDOMNUM = 1;


    @Test
    public void 차_생성시_거리_기본값() {
        Car car = new Car("sonata");
        int movingDistance = car.getMovingDistance();
        assertThat(movingDistance).isEqualTo(0);

    }

    @Test
    public void 차_이동시_거리_증가() {

        Car car = new Car("sonata");
        car.move(MOVEABLE_RANDOMNUM);
        car.move(NONE_MOVEABLE_RANDOMNUM);
        int movingDistance = car.getMovingDistance();
        assertThat(movingDistance).isEqualTo(1);
    }


}