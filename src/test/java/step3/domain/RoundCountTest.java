package step3.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.WrongGameSettingException;

class RoundCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 50, 100})
    @DisplayName("시도회수가 1이상이면 예외를 던지지 않는다.")
    void roundCount_ok_values(int count) {
        assertThatCode(() -> {
            RoundCount roundCount = new RoundCount(count);
        }).doesNotThrowAnyException();
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    @DisplayName("시도회수가 1이상이면 예외를 던지지 않는다.")
    void roundCount_ng_values(int count) {

        assertThatThrownBy(() -> {
            RoundCount roundCount = new RoundCount(count);
        }).isInstanceOf(WrongGameSettingException.class);

    }
}