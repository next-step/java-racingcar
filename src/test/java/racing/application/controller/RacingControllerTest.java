package racing.application.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.application.service.RacingServiceImpl;
import racing.domain.car.exception.BelowOfZeroException;
import racing.domain.car.exception.UnderOfZeroException;

class RacingControllerTest {


    RacingController racingController;

    @BeforeEach
    void setUp() {
        racingController = new RacingController(new RacingServiceImpl());
    }

    @ParameterizedTest
    @ValueSource(ints = {
        -1, 0
    })
    void 자동차_개수가_0이하면_예외가_발생한다(int numberOfCars) {
        int moveCount = 0;

        assertThatThrownBy(() -> racingController.racingGame(numberOfCars, moveCount))
            .isInstanceOf(BelowOfZeroException.class)
            .hasMessage("자동차는 1대 이상 입력 해야 합니다.");
    }

    @Test
    void 움직이는_횟수가_음수일_경우_예외가_발생한다() {
        int numberOfCars = 3;
        int moveCount = -1;

        assertThatThrownBy(() -> racingController.racingGame(numberOfCars, moveCount))
            .isInstanceOf(UnderOfZeroException.class)
            .hasMessage("0번 이상 움직여야 합니다.");

    }
}