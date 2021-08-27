package carracing.application;

import static org.assertj.core.api.Assertions.assertThat;

import carracing.domain.RaceResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingTest {

    private CarRacing carRacing;

    @BeforeEach
    void beforeEach() {
        carRacing = new CarRacing();
    }

    @Test
    @DisplayName("게임이 시작하면 지정된 회수만큼 게임이 진행된다.")
    void raceTest() {

        // given
        String inputName = "test1,test2,test3";
        int raceCount = 3;

        // when
        RaceResult results = carRacing.race(inputName, raceCount);

        // then
        assertThat(results.raceResult().size()).isEqualTo(raceCount);
    }

}