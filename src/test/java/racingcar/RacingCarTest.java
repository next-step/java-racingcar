package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    @DisplayName("입력한 숫자로 레이싱 정보 세팅 되는가")
    void makeRacingInfo() {
        RacingService racingService = new RacingService();

        // user가 "5", "3" 입력했다고 가정
        UserInput userInput = new UserInput("5", "3");
        RacingInfo racingInfo = new RacingInfo(userInput);

        // assert
        assertThat(racingInfo.getNumOfCars()).isEqualTo(Integer.parseInt(userInput.getNumOfCars()));
        assertThat(racingInfo.getNumOfTries()).isEqualTo(Integer.parseInt(userInput.getNumOfTries()));
        assertThat(racingInfo.getCarInfos().size()).isEqualTo(racingInfo.getNumOfCars());
    }

    @Test
    @DisplayName("random 값이 4 이상인 경우 전진하는가")
    void moveIfRandIsGreaterThan4() {
        RacingService racingService = new RacingService();

        // 시도 횟수 테스트를 위해 1로 설정
        RacingInfo racingInfo = new RacingInfo(new UserInput("5", "1"));
        // 전진 시도
        racingService.move(racingInfo);

        // assert
        for (CarInfo carInfo : racingInfo.getCarInfos()) {
            assertThat(carInfo.isRandGreaterThan4() == carInfo.isMoved()).isTrue();
        }
    }

    @Test
    @DisplayName("통합 테스트")
    void getCurrentStateOfRacing() throws InterruptedException {
        RacingService racingService = new RacingService();
        InputView inputView = new InputView();

        // 유저로부터 자동차 대수, 전진 시도 횟수 입력받음
        UserInput userInput = inputView.getRacingInfo();
        RacingInfo racingInfo = new RacingInfo(userInput);

        racingService.moveByNumOfTriesAndShowResult(racingInfo);
    }
}
