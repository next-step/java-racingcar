package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    public static final int THRESHOLD = 4;

    @Test
    @DisplayName("입력한 숫자로 레이싱 정보 세팅 되는가")
    void makeRacingInfo() {
        // user가 "5", "3" 입력했다고 가정
        UserInput userInput = new UserInput("5", "3");
        Racing racing = new Racing(userInput);

        // assert
        assertThat(racing.getNumOfCars()).isEqualTo(Integer.parseInt(userInput.getNumOfCars()));
        assertThat(racing.getNumOfTries()).isEqualTo(Integer.parseInt(userInput.getNumOfTries()));
        assertThat(racing.getCars().size()).isEqualTo(racing.getNumOfCars());
    }

    @Test
    @DisplayName("random 값이 4 이상인 경우 전진하는가")
    void moveIfRandIsGreaterThan4() {
        RacingService racingService = new RacingService();

        // 시도 횟수 테스트를 위해 1로 설정
        Racing racing = new Racing(new UserInput("5", "1"));
        // 전진 시도
        racingService.move(racing);

        // assert
        for (Car car : racing.getCars()) {
            assertThat(
                    car.isRandGreaterThan(THRESHOLD) == car.isMoved(car.diffBetweenCurrentDistAndPrevDist())
            ).isTrue();
        }
    }

    @Test
    @DisplayName("통합 테스트")
    void getCurrentStateOfRacing() {
        RacingService racingService = new RacingService();
        InputView inputView = new InputView();

        // 유저로부터 자동차 대수, 전진 시도 횟수 입력받음
        UserInput userInput = inputView.getRacingInfo();
        Racing racing = new Racing(userInput);

        racingService.moveByNumOfTriesAndShowResult(racing);
    }
}
