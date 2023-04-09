package domain;

import static domain.RandomNumber.generateRandomOutOfTen;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    @DisplayName("임의의 값을 생성한다.")
    void getRamDome() {
        int randomValue = generateRandomOutOfTen();

        assertThat(randomValue).isBetween(0, 10);
    }

}
