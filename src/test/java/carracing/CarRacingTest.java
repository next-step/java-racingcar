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
    @DisplayName("메인 기능 테스트")
    void main() throws CarNameFormatException {

        String carNames = "car1,car2,car3";
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). : " + carNames);

        String tryCount = "5";
        System.out.println("시도할 회수는 몇 회 인가요? : " + tryCount);

        CarRacing carRacing = new CarRacing();
        carRacing.racingStart(new InputInfo(carNames, tryCount));
    }

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
