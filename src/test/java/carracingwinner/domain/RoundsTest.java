package carracingwinner.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RoundsTest {

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false"})
    void playOneRoundTest(int roundCount, boolean isEnd) {
        String carNames = "pobi,kim";
        Cars cars = new Cars(carNames.split(","));
        Rounds rounds = new Rounds(roundCount);

        rounds.playOneRound(cars);

        assertThat(rounds.isEnd()).isEqualTo(isEnd);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,true", "0,true", "1,false"})
    void isEndTest(int roundCount, boolean isEnd) {
        Rounds rounds = new Rounds(roundCount);
        assertThat(rounds.isEnd()).isEqualTo(isEnd);
    }

}