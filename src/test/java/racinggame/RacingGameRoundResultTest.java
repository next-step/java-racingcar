package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameRoundResultTest {

    @DisplayName("구성하는 값이 같으면 라운드의 결과는 같아야 한다.")
    @Test
    void equalsAndHashCode() {
        assertThat(new RacingGameRoundResult(List.of(0, 1, 2))).isEqualTo(new RacingGameRoundResult(List.of(0, 1, 2)));
    }

}
