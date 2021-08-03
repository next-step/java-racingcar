package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceResult;
import racingcar.domain.Record;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceTest {
    private Race race = new Race(new Cars("a", "b"), 2, new MoveRaceStrategy());

    @Test
    @DisplayName("play 하면 결과로 raceResult 리턴")
    public void play() {
         RaceResult result = race.play();

         assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("play 하면 전략에 맞게 move 여부 결정")
    public void playByStrategy() {
        assertFinalLapDistance(race.play(), 2);

        Race notMoveRace = new Race(new Cars("c", "d"), 2, new NotMoveRaceStrategy());
        assertFinalLapDistance(notMoveRace.play(), 0);
    }

    private void assertFinalLapDistance(RaceResult result, int expectedDistance) {
        for (Record record : result.getLastLap().getRecords()) {
            assertThat(record.getDistance()).isEqualTo(expectedDistance);
        }
    }
}