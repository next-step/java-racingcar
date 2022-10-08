package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("nacho", 0);
    }
    @Test
    @DisplayName("자동차가 제대로 움직이는가?")
    void moveCarTest() {
        car.move(() -> true);
        assertThat(car).isEqualTo(new Car("nacho", 1));
    }

    @Test
    @DisplayName("자동차가 움직여야하면 안되는 상황에서는 제대로 정지해있는가?")
    void stopCarTest(){
        car.move(() -> false);
        assertThat(car).isEqualTo(new Car("nacho", 0));
    }
}