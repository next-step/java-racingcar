package racing.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

class RacingReportTest {

    @Test
    @DisplayName("라운드 결과를 반환한 이후, carList 가 업데이트 되어도 이전 결과에 영향을 주면 안된다.")
    void returnImmutableRoundResults() {
        RacingReport racingReport = new RacingReport();

        Car car = new Car(() -> 1, "test");
        List<Car> carList = new ArrayList<>();
        carList.add(car);

        racingReport.saveRoundResult(carList);

        List<RoundResult> firstRoundResults = racingReport.getRoundResults();

        Car car2 = new Car(() -> 1, "test2");
        carList.add(car2);
        racingReport.saveRoundResult(carList);

        List<RoundResult> secondRoundResults = racingReport.getRoundResults();

        assertAll(
            assertThat(secondRoundResults.size() != firstRoundResults.size())::isTrue,
            () -> assertThat(secondRoundResults).hasSize(2),
            () -> assertThat(firstRoundResults).hasSize(1)
        );
    }

    @Test
    @DisplayName("우승자 명단을 반환한 이후, 명단이 업데이트 되어도 이전 결과에 영향을 주면 안된다.")
    void returnImmutableWinnerList() {
        RacingReport racingReport = new RacingReport();

        racingReport.addWinner("pobi");

        List<String> firstWinners = racingReport.getWinners();

        racingReport.addWinner("honux");

        List<String> secondWinners = racingReport.getWinners();

        assertAll(
            assertThat(secondWinners.size() != firstWinners.size())::isTrue,
            () -> assertThat(secondWinners).hasSize(2),
            () -> assertThat(firstWinners).hasSize(1)
        );
    }

}
