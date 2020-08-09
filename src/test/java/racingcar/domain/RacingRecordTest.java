package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import racingcar.service.RacingGameStub;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingRecordTest {

    private List<String> carNames;

    @BeforeAll
    void setUp() {
        carNames = Arrays.asList(
                "YANG",
                "KYUNG",
                "JUNG"
        );
    };


    @Test
    @DisplayName("최종 우승자 파악 테스트")
    void getRoundRecordTest() {
        // given
        RacingGameStub racingGameStub = new RacingGameStub(carNames, carNames.size());

        // when
        racingGameStub.start();
        List<RacingRound> racingResults = racingGameStub.getRoundResults();

        // then
        RacingRound racingRound = racingResults.get(racingResults.size()-1);
        List<String> bestScoreCars = racingRound.getWinners();
        assertFalse(bestScoreCars.isEmpty());
    }
}
