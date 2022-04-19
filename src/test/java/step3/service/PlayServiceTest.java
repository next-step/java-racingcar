package step3.service;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.Position.DEFAULT_POSITION;
import static step3.domain.RacingGameTest.TRY_COUNT;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.RacingHistories;
import step3.domain.RandomProceedPolicy;

class PlayServiceTest {

    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("crong");
        carNames.add("honux");
    }

    @Test
    void playGameTest() {
        PlayService service = new PlayService(new RandomProceedPolicy());

        service.createGame(carNames);
        RacingHistories racingHistories = service.playRacingGame(TRY_COUNT);

        assertThat(racingHistories.getHistories()).hasSize(TRY_COUNT + DEFAULT_POSITION);
    }

}