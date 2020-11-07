package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ElectronicControlUnitTest {


    private ElectronicControlUnit ecu;

    @BeforeEach
    void setUp() {
        this.ecu = new ElectronicControlUnit();
        this.ecu.speedRecord("1");
        this.ecu.speedRecord("0");
        this.ecu.speedRecord("1");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1,0", "2:1,0,1"}, delimiter = ':')
    @DisplayName("ElectronicControlUnit 기록된 코드를 확인 ")
    void 전자제어장치_저장된_기록_확인(int index, String value) {
        assertThat(ecu.findRecord(index)).isEqualTo(value);
    }
}
