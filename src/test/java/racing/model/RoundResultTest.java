package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RoundResultTest {

    @Test
    @DisplayName("최종 우승자 선정")
    void 우승자() {
        RacingResult result = new Racing("pobi,crong", 3).start();

        RoundResult lastRoundResult = result.getRecords().get((result.getRecords().size() - 1));

        int topPosition = lastRoundResult.getRecords()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);

        StringJoiner expected = new StringJoiner(", ");
        lastRoundResult.getRecords()
                .stream()
                .filter(x -> x.getPosition() == topPosition)
                .map(Car::getName)
                .forEach(expected::add);

        assertThat(result.getWinner()).isEqualTo(expected.toString());
    }
}