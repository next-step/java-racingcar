package carracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private static final RacingCar RACING_CAR = new RacingCar();

    @ParameterizedTest
    @CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
    void 자동차_이동_가능여부_확인(int moveNum, boolean shouldMoveResult) {
        assertThat(RACING_CAR.shouldMove(moveNum)).isEqualTo(shouldMoveResult);
    }

    @Test
    void 차량_개수를_확인한다() {
        assertThat(RACING_CAR.race(3,5).size()).isEqualTo(3);
    }

    @Test
    void 차량_이동_횟수_0_이상_확인() {
        assertThat(RACING_CAR.race(3, 5).values()).allMatch(value -> value >= 0);
    }

}
