package study.step_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step_3.ui.UiController;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    RacingCarGame racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCarGame(new UiController());
    }

    @DisplayName("참여하는 자동차의 댓수 만큼 이를 List 에 생성하고 반환한다.")
    @ParameterizedTest
    @CsvSource({"5,5", "10,10", "15,15"})
    void setUpRacingCar(int numberOfCars, int expectedListSize) {
        assertThat(racingCar.setUpRacingCar(numberOfCars)).hasSize(expectedListSize);
    }

}