package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차를_이동_시킨다(){
        Car car = new Car();
        car.move();
        assertThat(car.compare(car, new Car())).isIn(1, 0);
    }

    @Test
    void 자동차_위치_표시_테스트(){
        Car car = new Car();
        car.move();
        assertThat(car.location()).isIn("", "-");
    }

}