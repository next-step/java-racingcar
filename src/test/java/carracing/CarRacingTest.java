package carracing;

import carracing.controller.CarRacing;
import carracing.domain.RaceResult;
import carracing.exception.CarNameFormatException;
import carracing.view.InputInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

    @Test
    @DisplayName("주어진 횟수 동안 경주 진행 여부 테스트")
    void tryCount() throws CarNameFormatException {
        String carNames = "car1,car2,car3";
        String tryCount = "5";

        CarRacing carRacing = new CarRacing();
        RaceResult result = carRacing.racingStart(new InputInfo(carNames, tryCount));

        int roundCount = Integer.parseInt(tryCount);
        Assertions.assertThat(result.roundCount).isEqualTo(roundCount);
    }

    @Test
    @DisplayName("주어진 횟수 동안 모든 자동차가 시도한 주행 횟수 테스트")
    void totalCount() throws CarNameFormatException {
        String carNames = "car1,car2,car3";
        String tryCount = "13";

        CarRacing carRacing = new CarRacing();
        InputInfo inputInfo = new InputInfo(carNames, tryCount);
        RaceResult result = carRacing.racingStart(inputInfo);

        Assertions.assertThat(result.roundCount * inputInfo.getCarCount()).isEqualTo(inputInfo.getTotalDrivingCount());
    }

}
