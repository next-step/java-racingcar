package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.RoundOutOfRangeException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("판들(Rounds) 테스트")
class RoundsTest {

    @DisplayName("판들은 양수를 허용한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void create(int value) {
        // when
        Rounds rounds = Rounds.of(value);


        // then
        assertThat(rounds).isNotNull();
    }

    @DisplayName("판들은 0과 음수 값을 허용하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    void createNotZeroAndNegative(int value) {
        // when / then
        assertThrows(RoundOutOfRangeException.class, () -> Rounds.of(value));
    }

    @DisplayName("게임 보고서를 만들 수 있다.")
    @Test
    void play() {
        // given
        Rounds rounds = Rounds.of(5);

        // when
        GameReport gameReport = rounds.play(Cars.of(Arrays.asList(Car.of("T"))), () -> true);

        // then
        assertThat(gameReport).isNotNull();
    }
}
