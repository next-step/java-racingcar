package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.service.NumberGenerator;
import racing.service.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0에서 9 사이의 랜덤 숫자를 얻는다.")
    void 랜덤_숫자_얻기_테스트() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Integer randomNumber = randomNumberGenerator.getNumber();
        assertThat(isNumberInRange(randomNumber)).isTrue();
    }

    private boolean isNumberInRange(int number) {
        return number >= 0 && number <= 9;
    }
}
