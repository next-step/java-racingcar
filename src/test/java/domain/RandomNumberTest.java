package domain;

import static domain.RandomNumber.generateRandomOutOfTen;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNumberTest {

    @Test
    @DisplayName("임의의 값을 생성한다.")
    void getRandom() {
        int randomValue = generateRandomOutOfTen();

        assertThat(randomValue).isBetween(0, 10);
    }

    @ParameterizedTest(name = "4 이상의 수가 나올 경우, true > {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void moreThanFour(int number) {
        boolean overFourOutOfTen = RandomNumber.isOverFourOutOfTen(number);
        assertThat(overFourOutOfTen).isTrue();
    }
}
