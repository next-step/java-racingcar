package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomNumber;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RandomNumberTest {
    @DisplayName("랜덤넘버추출 체크_숫자가 0이상 9이하")
    @Test
    void 랜덤넘버_추출값_확인() {
        assertThat(RandomNumber.randomNumberExtraction()).isBetween(0, 9);
    }

    @DisplayName("10만큼 반복")
    @Test
    void 랜덤넘버_추출값_반복확인() {
        for (int i = 0; i < 10; i++) {
            랜덤넘버_추출값_확인();
        }
    }
}
