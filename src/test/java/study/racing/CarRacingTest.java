package study.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racing.view.ResultView;

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
            racingResults.getRecordList().get(i).getSingleRecords().stream().forEach(record -> assertThat(record.getPosition()).isEqualTo(round * step));
        });
    }

    @DisplayName("항상 전진하여 자동차별로 동률이 발생했을때 우승자가 모두 출력되는지 테스트")
    @Test
    void getWinners_WhenTieRecord(){

        int tryCnt = 4;
        int step = 2;
        String[] carNames = {"A","B"};
        int carCnt = carNames.length;
        CarRacing carRacing = new CarRacing(() -> step);
        RacingRecords racingResults = carRacing.start(carNames, tryCnt);

        assertThat(carCnt).isEqualTo(racingResults.getWinners().size());
    }

}
