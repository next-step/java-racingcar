package carracingwinner.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundsTest {

    @Test
    void playRoundsTest() {
        int roundCount = 5;
        String carNames = "pobi,kim";
        Cars cars = new Cars(carNames.split(","));
        Rounds rounds = new Rounds(roundCount);

        rounds.playRounds(cars);

        assertThat(rounds.getResults().size()).isEqualTo(roundCount);
        assertThat(rounds.getLastWinners().size()).isGreaterThan(0);
    }

}