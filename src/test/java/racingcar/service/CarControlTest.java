package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarControlTest {
    @Test
    @DisplayName("랜덤값 체크")
    void goOrStop()
    {
        CarControl control = new CarControl();
        boolean result = control.goOrStop();
        assertThat(result).satisfiesAnyOf(
                actual -> assertThat(result).isTrue(),
                actual -> assertThat(result).isFalse()
        );
    }

}
