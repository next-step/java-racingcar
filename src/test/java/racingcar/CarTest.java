package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    void Car객체_생성_테스트() {
        Car car = Car.createCar();
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void 자동차는_움직일_수_있다() {
        DrivingRule mockRule = () -> true;

        Car car = Car.createCarWithDrivingRule(mockRule);

        assertThat(car.move()).isEqualTo(1);
        assertThat(car.move()).isEqualTo(2);
        assertThat(car.move()).isEqualTo(3);
    }
}