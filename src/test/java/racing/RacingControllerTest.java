package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.common.ErrorMessage;
import racing.controller.RacingController;
import racing.view.RacingView;

class RacingControllerTest {
    private RacingController controller;    
    
    @BeforeEach
    void setUp() {
        controller = new RacingController(new RacingView());
    }
    
    @Test
    void makeNewGameSuccessTest() {
        Assertions.assertThat(controller.makeNewGame(TestData.DEFAULT_CAR_NAME, TestData.DEFAULT_TIME)).isNotNull();
    }
    
    @Test
    void makeNewGameFailTest() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> controller.makeNewGame(null, TestData.DEFAULT_TIME))
            .withMessage(ErrorMessage.INCORRECT_CAR_NAMES.getMessage());
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> controller.makeNewGame(TestData.DEFAULT_CAR_NAME, TestData.ZERO_TIME))
            .withMessage(ErrorMessage.INCORRECT_TIME.getMessage());
    }
}
