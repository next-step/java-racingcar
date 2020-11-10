package study.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racing.view.InputView;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingInputValidationTest {
    CarRacing carRacing;

    @BeforeEach
    void setUp(){
        carRacing = new CarRacing(new RandomMoveStrategy());
    }

    @DisplayName("자동차 대수를 0으로 입력한 경우")
    @Test
    void inputCarCountZeroTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carRacing.start(new String[]{}, 3);
        }).withMessageContaining(RacingErrorMessage.ZERO_CAR_COUNT.getErrorMessage());
    }

    @DisplayName("시도 횟수를 0으로 입력한 경우")
    @Test
    void inputTryCountZeroTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carRacing.start(new String[]{"A","B"}, 0);
        }).withMessageContaining(RacingErrorMessage.ZERO_TRY_COUNT.getErrorMessage());
    }

}
