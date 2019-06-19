package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private CarName name;
    private DrivingRule mockTrueRule;
    private DrivingRule mockFalseRule;

    @BeforeEach
    void setUp() {
        name = CarName.valueOf("yong");
        mockTrueRule = () -> true;
        mockFalseRule = () -> false;
    }

    @Test
    void Car는_이름으로_생성_가능하다() {
        Car car = Car.create(name);
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void Car는_이름과_DrivingRule로_생성_가능하다() {
        Car car = Car.createWithDrivingRule(name, mockTrueRule);
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void Car는_CarInformation으로_자신의_정보를_전달할_수_있다() {
        Car car = Car.create(name);
        assertThat(car.getInformation()).isInstanceOf(CarInformation.class);
    }

    @Test
    void 자동차는_움직일_수_있다() {
        Car car = Car.createWithDrivingRule(name, mockTrueRule);

        assertThat(car.move()).isEqualTo(Position.valueOf(1));
        assertThat(car.move()).isEqualTo(Position.valueOf(2));
        assertThat(car.move()).isEqualTo(Position.valueOf(3));
    }

    @Test
    void 자동차는_정지할_수_있다() {
        Car car = Car.createWithDrivingRule(name, mockFalseRule);

        assertThat(car.move()).isEqualTo(Position.valueOf(0));
        assertThat(car.move()).isEqualTo(Position.valueOf(0));
        assertThat(car.move()).isEqualTo(Position.valueOf(0));
    }

    @Test
    void 자동차는_이름이_같으면_동등하다() {
        Car car1 = Car.create(name);
        Car car2 = Car.create(name);

        assertThat(car1.equals(car2)).isTrue();
    }
}