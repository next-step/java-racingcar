package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceTest {
    private Race sut = new Race(3, 2);

    @Test
    @DisplayName("play 하면 결과로 raceResult 리턴")
    public void play() {
         RaceResult result = sut.play();

         assertThat(result).isNotNull();
    }
}