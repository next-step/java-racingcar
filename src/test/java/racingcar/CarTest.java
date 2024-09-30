package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getTotalMoveCnt() {
        Car car = getCar();
        assertThat(car.getMoveTotalCnt()).isEqualTo(0);
    }

    @Test
    void run_전진() {
        Car car = getCar();

        car.run(true);

        assertThat(car.getMoveTotalCnt()).isEqualTo(1);
    }

    @Test
    void run_멈춤() {
        Car car = getCar();

        car.run(false);

        assertThat(car.getMoveTotalCnt()).isEqualTo(0);
    }

    private static Car getCar() {
        CarManager carManager = new CarManager();
        return carManager.createCarsByCnt(1).get(0);
    }


}