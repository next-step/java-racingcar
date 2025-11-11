import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource({"0,0", "3,0", "4,1", "9,1"})
    @DisplayName("4 이상의 숫자를 입력하면 1칸, 4 미만의 숫자를 입력하면 0칸 전진한다.")
    void moveTest(int number, int expectedLocation) {
        car.makeMove(number);
        assertThat(car.currentLocation()).isEqualTo(expectedLocation);
    }
}