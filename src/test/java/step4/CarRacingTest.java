package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.utility.ReturnRandomValue;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @Test
    @DisplayName("난수 생성 테스트")
    public void createRandom() {
        final int BIG_NUMBER = 10000;

        for (int i = 0; i < BIG_NUMBER; i++) {
            assertThat(ReturnRandomValue.returnValue()).isBetween(0, 9);
        }
    }

}
