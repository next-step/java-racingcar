package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import racingcar.model.RacingCar;
import racingcar.model.RacingRecord;
import racingcar.model.RacingRound;
import racingcar.model.Rule;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingRecordTest {

    private RacingRound racingRound;

    @BeforeAll
    void setUp() {
        racingRound = new RacingRound(Arrays.asList(
                new RacingCar("1"),
                new RacingCar("2"),
                new RacingCar("3")
        ));

        Rule racingRule = () -> true;
        racingRound.race(racingRule);
    };


    @Test
    @DisplayName("경기 결과가 생성 되는지 테스트")
    void getRoundRecordTest() {
        // given
        RacingRecord racingRecord = new RacingRecord();

        // when
        racingRecord.record(racingRound);
        List<String> allRecord = racingRecord.getAllRecord();

        // then
        assertThat(allRecord).containsExactly("-\n-\n-");
    }


}
