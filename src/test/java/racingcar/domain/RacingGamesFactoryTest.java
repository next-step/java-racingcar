package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.RacingGamesFactory.createRacingGames;

public class RacingGamesFactoryTest {

    @Test
    void createRacingGamesTest () {
        assertThat(createRacingGames("pobi,crong,honux",0)).hasSize(0);
        assertThat(createRacingGames("pobi,crong",5)).hasSize(5);
    }
}