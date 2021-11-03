package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @DisplayName("Position은 생성자로 입력된 값을 가지고 있는다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2"}, delimiter = ':')
    void createTest(Long input, Long expect) {
        Position actual = Position.create(input);

        assertThat(actual).isEqualTo(Position.create(expect));
    }

    @DisplayName("move가 호출 되면 position의 값이 1 증가한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3"}, delimiter = ':')
    void moveTest(Long input, Long expect) {
        Position actual = Position.create(input);

        assertThat(actual.move()).isEqualTo(Position.create(expect));
    }
}