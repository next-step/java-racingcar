package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:''","1:-", "2:--", "3:---" }, delimiter = ':')
    @DisplayName("전진하고 거리를 확인한다")
    void move(int tryInput, String expected) {
        for (int i=0; i<tryInput; i++) {
            car.move();
        }
        assertThat(car.getDistance()).isEqualTo(expected);
    }

}
