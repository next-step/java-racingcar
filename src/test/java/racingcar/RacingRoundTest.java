package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import racingcar.model.RacingCar;
import racingcar.model.RacingRound;
import racingcar.model.Rule;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingRoundTest {

    @Test
    @DisplayName("경기 결과가 생성 되는지 테스트")
    void getRoundRecordTest() {
        // given
        RacingRound racingRound = new RacingRound(Arrays.asList(
                new RacingCar("1"),
                new RacingCar("2"),
                new RacingCar("3"),
                new RacingCar("4"),
                new RacingCar("5")
        ));

        Rule racingRule = () -> true;
        racingRound.race(racingRule);

        // when
        String roundRecord = racingRound.getRoundRecord();

        // then
        assertEquals("-\n-\n-\n-\n-", roundRecord);
    }
}
