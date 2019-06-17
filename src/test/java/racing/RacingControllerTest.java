package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.common.ErrorMessage;
import racing.view.InputView;
import racing.view.RacingView;
import racing.view.ResultView;

class RacingControllerTest {
    private RacingController controller;    
    
    @BeforeEach
    void setUp() {
        controller = new RacingController(new RacingView(new InputView(), new ResultView()));
    }
    
    @Test
    void makeNewGameSuccessTest() {
        Assertions.assertThat(controller.makeNewGame("aa, bb", 3)).isNotNull();
    }
    
    @Test
    void makeNewGameFailTest() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> controller.makeNewGame(null, 5))
            .withMessage(ErrorMessage.INCORRECT_CAR_NAMES.getMessage());
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> controller.makeNewGame("aa,bb", 0))
            .withMessage(ErrorMessage.INCORRECT_TIME.getMessage());
    }
}
