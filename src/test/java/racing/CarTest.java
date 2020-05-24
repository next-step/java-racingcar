package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @DisplayName("Car 전진 또는 정지")
    @ValueSource(ints = {1, 0})
    void moveTest(int expected) {
        //Car car = new Car(new CarForwardBehavior());

       // assertThat(CarForwardBehavior.action()).isEqualTo(expected);
    }
}

