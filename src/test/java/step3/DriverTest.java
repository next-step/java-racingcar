package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    Driver driver;

    @BeforeEach
    void setUp() {
        driver = new Driver();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:''","3:''", "4:-", "5:-" }, delimiter = ':')
    @DisplayName("4이상 전진, 4미만 정지 기능 테스트")
    void move(int input, String expected) {
        driver.drive(input);
        assertThat(driver.getCarDistance()).isEqualTo(expected);
    }

}