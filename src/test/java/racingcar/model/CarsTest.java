package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.enums.Status;
import racingcar.model.wrapper.ForwardNumber;

import java.util.List;

import static racingcar.model.enums.Status.*;

public class CarsTest {
    @Test
    void 자동차들의_주어진_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        int forwardNumber = 4;
        int stopNumber = 0;

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Cars cars = new Cars(List.of(car1,car2,car3));

        car1.move(new ForwardNumber(forwardNumber));
        car1.move(new ForwardNumber(forwardNumber));
        car1.move(new ForwardNumber(stopNumber));
        car1.move(new ForwardNumber(forwardNumber));

        car2.move(new ForwardNumber(forwardNumber));
        car2.move(new ForwardNumber(forwardNumber));
        car2.move(new ForwardNumber(forwardNumber));
        car2.move(new ForwardNumber(forwardNumber));

        car3.move(new ForwardNumber(forwardNumber));
        car3.move(new ForwardNumber(stopNumber));
        car3.move(new ForwardNumber(stopNumber));
        car3.move(new ForwardNumber(forwardNumber));

        Car car1Expected = new Car(List.of(FORWARD, FORWARD, STOP, FORWARD));
        Car car2Expected = new Car(List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car3Expected = new Car(List.of(FORWARD, STOP, STOP, FORWARD));
        Cars expected = new Cars(List.of(car1Expected, car2Expected, car3Expected));

        Assertions.assertThat(cars).isEqualTo(expected);

    }
}
