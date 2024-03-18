package step3.application.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DriverTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi:3", "crong:1", "honux:2"}, delimiter = ':')
    void test(String name, int position) {
        Driver driver = new Driver(name);
        MovementLog movementLog = driver.logNameAndPosition(position);
        Assertions.assertThat(movementLog).isEqualTo(new MovementLog(name, position));
    }

}