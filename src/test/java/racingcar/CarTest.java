package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 전진() {
        Car car = new Car();

        for (int i = 1; i <= 10; i++) {
            car.go();
            int movedDistance = car.getMovedDistance();
            assertThat(movedDistance).isEqualTo(i);
        }
    }

    @Test
    public void 무작위_전진() {
        Car car = new Car();
        int movedDistance = 0;

        for (int i = 0; i < 10; i++) {
            boolean didCarGo = car.randomlyGo();

            if (didCarGo)
                movedDistance++;
        }

        assertThat(movedDistance).isEqualTo(car.getMovedDistance());
    }
}
