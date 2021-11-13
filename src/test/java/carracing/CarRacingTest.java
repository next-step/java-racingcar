package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

    @Test
    @DisplayName("메인 기능 테스트")
    void main() {

        String carCount = "3";
        System.out.println("자동차 대수는 몇 대 인가요? : " + carCount);

        String tryCount = "5";
        System.out.println("시도할 회수는 몇 회 인가요? : " + tryCount);

        CarRacing carRacing = new CarRacing();
        carRacing.racingStart(carCount, tryCount);
    }

    @Test
    @DisplayName("주어진 횟수 동안 경주 진행 여부 테스트")
    void tryCount() {
        String carCount = "3";
        String tryCount = "5";

        CarRacing carRacing = new CarRacing();
        RaceResult result = carRacing.racingStart(carCount, tryCount);

        int roundCount = Integer.parseInt(tryCount);
        Assertions.assertThat(result.roundCount).isEqualTo(roundCount);
    }

    @Test
    @DisplayName("주어진 횟수 동안 모든 자동차가 시도한 주행 횟수 테스트")
    void totalCount() {
        String carCount = "12";
        String tryCount = "13";

        CarRacing carRacing = new CarRacing();
        RaceResult result = carRacing.racingStart(carCount, tryCount);

        int totalCount = Integer.parseInt(carCount) * Integer.parseInt(tryCount);
        Assertions.assertThat(result.totalRaceCount).isEqualTo(totalCount);
    }

}
