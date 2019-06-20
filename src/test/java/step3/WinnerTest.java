package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.CarRace;
import step3.domain.Cars;
import step3.domain.Winners;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {

    private String testCarNames = "Car1,Car2,Car3,Car4,Car5";
    private int numberOfTrials = 10;
    private CarRace testRace = CarRace.raceStart(testCarNames, numberOfTrials);

    @BeforeEach
    void init() {
        for (int i = 0; i < numberOfTrials; i++) {
            testRace.executeTrials();
        }
    }

    @Test
    void 우승자들이_선정된다() {
        assertThat(testRace.pickWinners()).isNotNull();
    }

    @Test
    void 선정된_우승자들의_Position은_같다() {
        Winners testWinners = testRace.pickWinners();

        assertThat(testWinners.getWinners().stream()
                .distinct()
                .count()).isEqualTo(1);
    }

    @Test
    void 선정된_우승자들의_Position이_가장_크다() {
        //TODO: 구현 실패..
    }
}
