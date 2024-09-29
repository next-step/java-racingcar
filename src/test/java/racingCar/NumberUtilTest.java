package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {

        @Test
        @DisplayName("random 값은 항상 0 ~ 9 사이를 리턴한다.")
        void randomNumber_shouldBeBetweenOneAndNine() {
            assertThat(NumberUtil.getRandomInt()).isBetween(0, 9);
        }
}


