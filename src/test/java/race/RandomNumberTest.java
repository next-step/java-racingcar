package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    void 생성() {
        RandomNumber randomNumber = new RandomNumber(4);

        assertThat(randomNumber).isEqualTo(new RandomNumber(4));
    }

    @Test
    void RandomNumber는_10보다_작다() {
        assertThatThrownBy(() -> new RandomNumber(10))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void RandomNumber는_0보다_크다() {
        assertThatThrownBy(() -> new RandomNumber(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isBigOrEqual을_실행하면_주어진_수와_비교해서_결과를_반환한다() {
        RandomNumber randomNumber = new RandomNumber(4);

        boolean result = randomNumber.isBigOrEqual(5);

        assertThat(result).isFalse();
    }
}
