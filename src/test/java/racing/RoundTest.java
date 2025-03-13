package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    @DisplayName("라운드를 play하면 라운드가 종료된다")
    void playTest() {
        // given
        var round = new Round();

        // when
        round.play();

        // then
        Assertions.assertThat(round.isFinished()).isTrue();
    }
}
