package step3.application.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.application.domain.model.dto.MovementLog;
import step3.application.domain.model.vo.Driver;

class DriverTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi:3", "crong:1", "honux:2"}, delimiter = ':')
    void 유저의_이름과_이동거리를_기록(String name, int position) {
        Driver driver = new Driver(name);
        MovementLog movementLog = driver.logNameAndPosition(position);
        Assertions.assertThat(movementLog).isEqualTo(new MovementLog(name, position));
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:pobi:true", "crong:honux:false"}, delimiter = ':')
    void driver의_이름이_입력된_이름과_일치하는지_여부(String name, String input, boolean answer) {
        Driver driver = new Driver(name);
        Assertions.assertThat(driver.isSameAs(input)).isEqualTo(answer);
    }
}