package study.racing.domain;

import org.junit.jupiter.api.Test;
import study.racing.domain.move.TestMoveStrategy;

import static org.assertj.core.api.Assertions.*;


class CarTest {

    @Test
    void car_생성_성공() {
        Car car = new Car("car1");
        assertThat(car).isEqualTo(new Car("car1", 0));
    }

    @Test
    void 생성자_통해서_앞으로_3칸_전진() {
        Car car = new Car("car1", 3);
        assertThat(car.getPosition()).isEqualTo(new CarPosition(3));
    }

    @Test
    void 앞으로_3칸_전진() {
        Car car = new Car("car1", new TestMoveStrategy(true));
        for (int i = 0; i < 3; i++) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(new CarPosition(3));
    }

}