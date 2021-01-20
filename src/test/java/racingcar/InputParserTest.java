package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {

    @DisplayName("입력값이 null인 경우 exception 발생")
    @Test
    void carNamesNull() {
        // given
        String input = null;

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCarNames(input);
        });
        assertThat(exception.getMessage()).isEqualTo("입력값이 없습니다.");
    }

    @DisplayName("각 자동차 이름의 길이가 5자를 초과하면 exception 발생")
    @Test
    void carNameLengthLongerThanFive() {
        // given
        String input = "car1,gyumin,sanghyun";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCarNames(input);
        });
        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("3개의 자동차 이름을 입력하여 파싱")
    @Test
    void parseCarNames() {
        // given
        String input = "car1,car2,car3";

        // when
        List<String> parsedCarNames = InputParser.parseCarNames(input);

        // then
        assertThat(parsedCarNames.get(0)).isEqualTo("car1");
        assertThat(parsedCarNames.get(1)).isEqualTo("car2");
        assertThat(parsedCarNames.get(2)).isEqualTo("car3");
    }
}