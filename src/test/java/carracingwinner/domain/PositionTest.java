package carracingwinner.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void createSuccessTest(int value) {
        Position position = new Position(value);

        assertThat(position.getIntValue()).isEqualTo(value);
    }

    @Test
    void createFailTest() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Position 값은 ")
                .hasMessageContaining("보다 작을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void increaseTest(int value) {
        Position position = new Position(value);
        position.increase();

        assertThat(position.getIntValue()).isEqualTo(value + 1);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,''", "1,-", "2,--"})
    void getStringValue(int positionValue, String stringValue) {
        Position position = new Position(positionValue);

        assertThat(position.getStringValue()).isEqualTo(stringValue);
    }

}