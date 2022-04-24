package racingcarv2;

import org.junit.jupiter.api.Test;
import racingcar.model.PlayCount;

import static org.assertj.core.api.Assertions.assertThat;

class PlayCountTest {
    private PlayCount playCount;

    @Test
    void isLast() {
        playCount = new PlayCount(5);
        assertThat(playCount.isLast(5)).isTrue();
    }
}