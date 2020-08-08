package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RelayCameraTest {

    @DisplayName("자리이동 확인 TEST")
    @ParameterizedTest
    @CsvSource(value = {"2:1:2",
            "1:1:1"},
            delimiter = ':')
    void moveLocation(int currentLocation, int location, int result) {
        assertThat(RelayCamera.moveLocation(currentLocation, location)).isEqualTo(result);
    }
}