package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.Racing;
import racing.model.CarModel;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    CarModel car = new CarModel();
    Racing racing = new Racing();

    @Test
    @DisplayName("car distance check Test")
    void carDistanceCheckTest() {
        car.go();
        assertThat(car.totalDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:false", "5:true"}, delimiter = ':')
    @DisplayName("car move Test")
    void carMoveTest(int randomValue, boolean expected) {
        assertThat(racing.carMove(car, randomValue)).isEqualTo(expected);
    }
}
