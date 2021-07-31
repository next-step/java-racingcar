package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceTest {
    private Cars cars = new Cars("a", "b", "c");
    private Race race = new Race(cars, 2, new MoveRaceStrategy());

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

        Race notMoveRace = new Race(cars, 2, new NotMoveRaceStrategy());
        assertFinalLapDistance(notMoveRace.play(), 0);
    }

    private void assertFinalLapDistance(RaceResult result, int expectedDistance) {
        for (Distance distance : result.getLastLap().getDistances()) {
            assertThat(distance).isEqualTo(new Distance(expectedDistance));
        }
    }
}