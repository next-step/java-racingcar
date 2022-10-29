package rarcingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Car;

public class CarTest {

    @ParameterizedTest
    @CsvSource({"3,false", "4,true"})
    public void car_이동(int num, boolean moved) {
        Car testCar = new Car();
        assertThat(testCar.move(num).equals(new Car(1))).isEqualTo(moved);

        Car testCar2 = new Car(3);
        assertThat(testCar2.move(num).equals(new Car(4))).isEqualTo(moved);
    }

}
