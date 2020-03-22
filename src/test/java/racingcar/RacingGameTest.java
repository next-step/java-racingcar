package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RacingGameTest {

    @Test
    @DisplayName("게임을 진행할 때마다 자동차의 현재 위치를 리턴한다")
    public void moveCarsReturnsCurrentCarPosition() {
        Random random = mock(Random.class);
        when(random.nextInt(10))
                .thenReturn(4);

        RacingGame game = new RacingGame(random, 3);

        assertThat(game.move()).containsExactly(1, 1, 1);
        assertThat(game.move()).containsExactly(2, 2, 2);
    }
}
