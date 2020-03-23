package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RacingGameTest {

    @Test
    @DisplayName("게임을 진행할 때마다 자동차들은 각각 랜덤하게 전진한다")
    public void progressGameMoveCarsByRandom() {
        Random random = mock(Random.class);
        when(random.nextInt(10))
                .thenReturn(4);

        InputData inputData = new InputData(3, 5);

        RacingGame game = new RacingGame(random, inputData);

        game.progress();

        List<Car> cars = game.getCars();

        assertThat(
                cars
                        .stream()
                        .map(c -> c.getPosition())
        ).containsExactly(1, 1, 1);
    }
}
