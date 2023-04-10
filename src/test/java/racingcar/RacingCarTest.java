package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    @DisplayName("입력받은 숫자만큼 자동차 생성")
    void makeRacingInfo() {
        // 초기 세팅
        InputView inputView = new InputView();
        RacingService racingService = new RacingService();

        // 유저 입력
        UserInput userInput = inputView.getRacingInfo();
        // 입력받은 숫자만큼 자동차 생성
        RacingInfo racingInfo = racingService.makeRacingInfo(userInput);

        // assert
        assertThat(racingInfo.getNumOfCars()).isEqualTo(Integer.parseInt(userInput.getNumOfCars()));
        assertThat(racingInfo.getNumOfTries()).isEqualTo(Integer.parseInt(userInput.getNumOfTries()));
    }

    @Test
    @DisplayName("random 값이 4 이상인 경우 전진")
    void moveFowardIfRandIsGreaterThan4() {
        // 초기 세팅
        RacingService racingService = new RacingService();
        RacingInfo racingInfo = racingService.makeRacingInfo(new UserInput("5", "1"));

        // 1회 전진 시도
        racingService.moveFoward(1, racingInfo.getCarInfos());

        // assert
        for (CarInfo carInfo : racingInfo.getCarInfos()) {
            assertThat(carInfo.isRandGreaterThan4()).isTrue();
            assertThat(carInfo.isMoved()).isTrue();
        }
    }
}
