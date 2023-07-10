package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RoundTest {

    @Test
    void Round생성할때_성공() {
        // given
        final int input = 5;

        // when
        final Round round = Round.from(input);

        // then
        assertThat(round.getValue()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void zero이하의수로생성할때_실패_RuntimeException발생(int input) {
        // when & then
        assertThatThrownBy(() -> Round.from(input)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 같은라운드을가질때_같은객체로판단성공() {
        // given
        final int input = 5;
        final Round round1 = Round.from(input);
        final Round round2 = Round.from(input);

        // when & then
        assertThat(round1).isEqualTo(round2);
    }

    @Test
    void 다른라운드을가질때_다른객체로판단성공() {
        // given
        final int input1 = 3;
        final int input2 = 5;
        final Round round1 = Round.from(input1);
        final Round round2 = Round.from(input2);

        // when & then
        assertThat(round1).isNotEqualTo(round2);
    }

    @Test
    void 라운드가진행될때_감소성공() {
        // given
        final int input = 5;
        final Round round = Round.from(input);
        final int beforeRound = round.getValue();

        // when
        round.decrease();

        // then
        assertThat(round.getValue()).isEqualTo(beforeRound - 1);
    }
}