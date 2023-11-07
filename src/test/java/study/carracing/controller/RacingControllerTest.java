package study.carracing.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.carracing.domain.Racing;
import study.carracing.ui.ResultView;
import study.carracing.ui.TestInputView;

class RacingControllerTest {

    private static final int TRY_COUNT = 3;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("입력한 자동차 대수만큼 자동차 객체가 생성된다.")
    void createCar(int expected) {
        RacingController racingController = new RacingController(new TestInputView(expected, TRY_COUNT), new ResultView());
        Racing racing = racingController.start();

        int actual = racing.getRacingCars().size();
        assertThat(actual).isEqualTo(expected);
    }
}
