package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {

    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("abc", new Location(3));
    }

    @Test
    @DisplayName("랜덤값이 4이상이면 전진한다")
    void advanceSuccessTest() {
        car.moveLocation(4);
        assertThat(car.getLocation()).isEqualTo(4);
    }

    @Test
    @DisplayName("랜덤값이 4미만이면 전진하지않는다")
    void advanceFailTest() {
        car.moveLocation(3);
        assertThat(car.getLocation()).isEqualTo(3);
    }

    @Test
    @DisplayName("최대Location 값을 반환한다")
    void maxLocationTest() {
        assertThat(car.findMaxLocation(2)).isEqualTo(3);
        assertThat(car.findMaxLocation(4)).isEqualTo(4);
    }
}