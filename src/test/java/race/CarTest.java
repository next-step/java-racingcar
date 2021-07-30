package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;
    @BeforeEach
    void setting() {
        car = new Car("test1");
    }

    @Test
    @DisplayName("go Test")
    void goTest() {
        car.run(9);
        assertThat(car.totalDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("stop Test")
    void stopTest() {
        car.run(3);
        assertThat(car.totalDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("move condition test")
    void randomValueTest() {
        assertThatThrownBy(() -> {
            car.moveCondition(10);
        }).isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:false", "5:true"}, delimiter = ':')
    @DisplayName("car move Test")
    void carMoveTest(int randomValue, boolean expected) {
        assertThat(car.run(randomValue)).isEqualTo(expected);
    }


}
