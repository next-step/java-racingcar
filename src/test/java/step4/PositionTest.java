package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("Position은 생성자로 입력된 값을 가지고 있는다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2"}, delimiter = ':')
    void createTest(Integer input, Integer expect) {
        Position actual = Position.create(input);

        assertThat(actual).isEqualTo(Position.create(expect));
    }

    @DisplayName("move가 호출 되면 position의 값이 1 증가한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3"}, delimiter = ':')
    void moveTest(Integer input, Integer expect) {
        Position actual = Position.create(input);

        assertThat(actual.move()).isEqualTo(Position.create(expect));
    }

    @DisplayName("stringToPosition 을 통해 현재 위치를 -- 와 같이 표현한다 ")
    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---"}, delimiter = ':')
    void moveTest(Integer input, String expect) {
        Position actual = Position.create(input);

        assertThat(actual.toString()).isEqualTo(expect);

        actual = Position.create(0);
        assertThat(actual.toString()).isEqualTo("");
    }

    @DisplayName("withDefaultPosition() 은 기본 값인 0 의 포지션을 반환한다.")
    @Test
    void withDefaultPositionTest() {
        Position position = Position.withDefaultPosition();

        assertThat(position).isEqualTo(Position.create(0));
    }
}