package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomValueTest {

    @DisplayName("이동할지 안할지 결정하는 변수를 잘 생성할 수 있다.")
    @Test
    public void getValue_rangeZeroToNine_alwaysTrue() {
        RandomValue randomValue = new RandomValue();

        boolean result = true;
        for (int i = 0 ; i < 10000 ; i++) {
            int value = randomValue.getValue();

            if (value < 0 || value > 9) {
                result = false;
            }
        }
        Assertions.assertThat(result).isTrue();
    }
}
