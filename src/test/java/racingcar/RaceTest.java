package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceTest {
    private Race race = new Race(3, 2, new MoveRaceStrategy());

    @Test
    @DisplayName("play 하면 결과로 raceResult 리턴")
    public void play() {
         RaceResult result = race.play();

         assertThat(result).isNotNull();
    }
}