package car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {


    @ParameterizedTest
    @CsvSource(value = {"1,0", "9,1"})
    public void tryMove_직진한다(int givenCondition, int expected) {
        Car car = new Car(0);

        car.tryMove(givenCondition);
        Assertions.assertThat(car.getStraightCount()).isEqualTo(expected);
    }

}
