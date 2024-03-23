package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void car_전진한다(){
        Car car = new Car();
        car.move();
        assertThat(car.getLocation()).isEqualTo(2);
    }

}