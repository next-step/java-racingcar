package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.value.Round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RoundTest {

    @Test
    @DisplayName("정상적으로 생성 되는지 검증")
    void createTest() {
        Round round = Round.from(4);

        assertThat(round.getRound()).isEqualTo(4);
    }

    @Test
    @DisplayName("최대 10라운드 까지 가능")
    void createErrorTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Round.from(11));
    }
}
