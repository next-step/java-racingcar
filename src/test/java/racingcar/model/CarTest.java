package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    void Car객체_생성_테스트() {
        Car car = Car.create("yong");
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void Car는_CarInformation을_갖는다() {
        Car car = Car.create("yong");
        assertThat(car.getInformation()).isInstanceOf(CarInformation.class);
    }

    @Test
    void 자동차는_움직일_수_있다() {
        DrivingRule mockRule = () -> true;
        Car car = Car.createWithDrivingRule("yong", mockRule);

        assertThat(car.move()).isEqualTo(Position.valueOf(1));
        assertThat(car.move()).isEqualTo(Position.valueOf(2));
        assertThat(car.move()).isEqualTo(Position.valueOf(3));
    }

    @Test
    void 자동차는_정지할_수_있다() {
        DrivingRule mockRule = () -> false;
        Car car = Car.createWithDrivingRule("yong", mockRule);

        assertThat(car.move()).isEqualTo(Position.valueOf(0));
        assertThat(car.move()).isEqualTo(Position.valueOf(0));
        assertThat(car.move()).isEqualTo(Position.valueOf(0));
    }
}