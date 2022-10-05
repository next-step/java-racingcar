package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultsTest {

    @Test
    void add() {
        RoundResults roundResults = new RoundResults();

        roundResults.recordResults(List.of(1, 1, 1));

        assertThat(roundResults.getResults()).isEqualTo(List.of(List.of(1, 1, 1)));
    }
}
