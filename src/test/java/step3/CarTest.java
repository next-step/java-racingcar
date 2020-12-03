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
    @CsvSource(value = {"0:''","3:''", "4:-", "5:-" }, delimiter = ':')
    @DisplayName("4이상 전진, 4미만 정지 기능 테스트")
    void move(int input, String expected) {
        car.move(input);
        assertThat(car.getDistance()).isEqualTo(expected);
    }

}
