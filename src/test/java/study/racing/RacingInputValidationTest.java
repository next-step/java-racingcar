package study.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingInputValidationTest {
    CarRacing carRacing;

    @BeforeEach
    void setUp(){
        carRacing = new CarRacing();
    }

    @DisplayName("자동차 대수를 0으로 입력한 경우")
    @Test
    void inputCarCountZeroTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carRacing.racing(0, 3);
        }).withMessageContaining(RacingErrorMessage.ZERO_CAR_COUNT.getErrorMessage());
    }

    @DisplayName("시도 횟수를 0으로 입력한 경우")
    @Test
    void inputTryCountZeroTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carRacing.racing(2, 0);
        }).withMessageContaining(RacingErrorMessage.ZERO_TRY_COUNT.getErrorMessage());
    }

}
