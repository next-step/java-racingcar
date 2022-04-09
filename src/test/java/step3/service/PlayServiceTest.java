package step3.service;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.Car.DEFAULT_POSITION;
import static step3.domain.RacingGameTest.CAR_COUNT;
import static step3.domain.RacingGameTest.TRY_COUNT;

import java.util.List;
import org.junit.jupiter.api.Test;
import step3.domain.RandomProceedPolicy;

class PlayServiceTest {

    @Test
    void playGameTest() {
        PlayService service = new PlayService(new RandomProceedPolicy());

        List<String> historyStrings = service.playRacingGame(CAR_COUNT, TRY_COUNT);

        assertThat(historyStrings).hasSize(TRY_COUNT + DEFAULT_POSITION);
    }

}