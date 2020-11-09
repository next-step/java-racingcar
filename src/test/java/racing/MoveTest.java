package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Car;
import racing.model.RacingCar;

import static org.assertj.core.api.Assertions.*;

public class MoveTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("자동차가 움직이지 않는 경우")
    void testCanNotMove(int input) {
        Car testCar = new RacingCar();
        testCar.move(input);
        assertThat(testCar.currentLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    @DisplayName("자동차가 움직이는 경우")
    void testMove(int input) {
        Car testCar = new RacingCar();
        int beforeMove = testCar.currentLocation();
        testCar.move(input);
        assertThat(testCar.currentLocation() - beforeMove).isEqualTo(1);
    }

}
