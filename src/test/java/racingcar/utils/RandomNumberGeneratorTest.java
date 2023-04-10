package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @DisplayName("0 ~ 9 사이의 랜덤값을 생성한다.")
    @Test
    void generateRandomNumber() {
        for(int i = 0; i < 100000; i++) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber(0, 9);

            assertThat(randomNumber).isBetween(0, 9);
        }
    }
}
