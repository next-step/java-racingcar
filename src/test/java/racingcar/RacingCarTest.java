package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    @DisplayName("입력받은 숫자만큼 자동차 생성")
    void makeRacingInfo() {
        InputView inputView = new InputView();
        RacingService racingService = new RacingService();
        UserInput userInput = inputView.getRacingInfo();
        RacingInfo racingInfo = racingService.makeRacingInfo(userInput);

        assertThat(racingInfo.getNumOfCars()).isEqualTo(Integer.parseInt(userInput.getNumOfCars()));
        assertThat(racingInfo.getNumOfTries()).isEqualTo(Integer.parseInt(userInput.getNumOfTries()));
    }

    @Test
    @DisplayName("random 값이 4 이상인 경우 전진")
    void moveFoward() {
        RacingService racingService = new RacingService();
        RacingInfo racingInfo = racingService.makeRacingInfo(new UserInput("5", "1"));

        racingService.moveFoward(1, racingInfo.getCarInfos());
        for (CarInfo carInfo : racingInfo.getCarInfos()) {
            assertThat(carInfo.getResultOfRand()).isGreaterThan(4);
            assertThat(carInfo.getDistance()).isEqualTo(1);
        }
    }


}
