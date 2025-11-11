package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class CarTest {

    @Test
    void car_생성_성공(){
        Car car = new Car("car1");
        assertThat(car.getName()).isEqualTo("car1");
        assertThat(car.getPosition()).isEqualTo("");
    }

    @Test
    void 앞으로_1칸_전진(){
        Car car = new Car("car1");
        car.forwardPosition();
        assertThat(car.getPosition()).isEqualTo("-");
    }

}