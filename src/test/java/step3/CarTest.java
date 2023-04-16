package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @ParameterizedTest(name = "조건이 4 이상일 경우에만 전진한다")
    @CsvSource(value = {"1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    void isMove(int condition, int location) {
        car.move(condition);

        assertThat(car.getCurrentLocation())
                .isEqualTo(location);
    }
}
