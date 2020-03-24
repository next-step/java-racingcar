package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    private Round round;

    @BeforeEach
    void setUp() {
        round = new Round();
    }

    @DisplayName("다음 라운드로 넘어 갈 수 있다.")
    @Test
    void next() {
        // given
        final int expect = 1;

        // when
        final Round actual = round.next();

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getRound()).isEqualTo(1);
    }
}