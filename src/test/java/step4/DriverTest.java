package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    Driver driver;

    @BeforeEach
    void setUp() {
        driver = new Driver(new Car("jack"));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0","3:0", "4:1", "5:1" }, delimiter = ':')
    @DisplayName("4이상 전진, 4미만 정지 기능 테스트")
    void drive(int input, int expected) {
        driver.drive(input);
        assertThat(driver.getDistanceSize()).isEqualTo(expected);
    }

}