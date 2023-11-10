package racingcarwinner;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    void bound_내_랜덤_숫자_생성() {
        RandomNumber randomNumber = new RandomNumberImpl();
        assertThat(randomNumber.getRandomNumber(10)).isGreaterThanOrEqualTo(0);
        assertThat(randomNumber.getRandomNumber(10)).isLessThanOrEqualTo(9);
    }
}