package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.model.TestCar;
import racing.model.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    TestCar car;

    @BeforeEach
    void setting() {
        car = new TestCar("test1");
    }

    @Test
    @DisplayName("go Test")
    void goTest() {
        car.run(4);
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
            new RandomMovingStrategy().moveCondition(10);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("valid distance test")
    void validDistanceTest() {
        car.run(() -> true);
        assertThat(car.validDistance(1)).isEqualTo(true);
    }



}
