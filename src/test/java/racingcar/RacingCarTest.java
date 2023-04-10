package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    InputView inputView = new InputView();
    UserInput userInput;

    @Test
    @DisplayName("입력받은 숫자만큼 자동차 생성")
    void makeRacingInfo() {
        RacingService racingService = new RacingService();

        userInput = inputView.getRacingInfo();
        RacingInfo racingInfo = racingService.makeRacingInfo(userInput);

        assertThat(racingInfo.getNumOfCars()).isEqualTo(Integer.parseInt(userInput.getNumOfCars()));
        assertThat(racingInfo.getNumOfTries()).isEqualTo(Integer.parseInt(userInput.getNumOfTries()));
    }
}
