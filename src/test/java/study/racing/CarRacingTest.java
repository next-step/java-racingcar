package study.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @DisplayName("지정한 step 만큼 항상 전진하는지 테스트")
    @Test
    void alwaysForwardStrategyTest(){

        int tryCnt = 4;
        int step = 2;
        String[] carNames = {"A","B"};
        int carCnt = carNames.length;
        CarRacing carRacing = new CarRacing(() -> step);
        RacingRecords racingResults = carRacing.start(carNames, tryCnt);

        IntStream.range(0, tryCnt).forEach(i -> {
            int round = i+1;
            racingResults.getRecordList().get(i).getPositionList().stream().forEach(position -> assertThat(position).isEqualTo(round * step));
        });
    }
}
