package study.carracing.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.carracing.ui.TestInputView;

class RacingControllerTest {

    private static final int TRY_COUNT = 3;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("입력한 자동차 대수만큼 자동차 객체가 생성된다.")
    void createCar(int expected) {
        RacingController racingController = new RacingController();

        TestInputView inputView = new TestInputView(expected, TRY_COUNT);
        racingController.start(inputView.inputCarCount(), inputView.inputTryCount());

        int actual = racingController.getRacingCars().getCars().size();
        assertThat(actual).isEqualTo(expected);
    }
}
