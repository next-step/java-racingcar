package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("대기중인 자동차는 1개 이상이 아닐경우 에러를 던진다.")
    @Test
    void 대기_자동차_갯수_에러_검증() {
        assertThatThrownBy(() -> Cars.readyCars("", new RandomMoveStrategy())).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력한 댓수만큼 자동차가 대기해야한다.")
    @CsvSource(value = {"goni,alarm,matt|3", "goni,alarm,matt,range,lian|5"}, delimiter = '|')
    void 대기_자동차_갯수_검증(String input, int expected) {
        assertThat(Cars.readyCars(input, new RandomMoveStrategy()).getCars()).hasSize(expected);
    }

}
