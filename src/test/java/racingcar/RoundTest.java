package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    @DisplayName("경기 횟수는 1개 이상이 아닐경우 에러를 던진다.")
    @Test
    void 경기_횟수_에러_검증() {
        assertThatThrownBy(() -> new Round(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력한 횟수만큼 라운드가 존재해야한다.")
    @CsvSource(value = {"3|3", "5|5"}, delimiter = '|')
    void 대기_자동차_갯수_검증(int input, int expected) {
        assertThat(new Round(input).getNumber()).isEqualTo(expected);
    }

}
