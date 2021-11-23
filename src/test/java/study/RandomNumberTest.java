package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    @DisplayName("0에서 9 사이의 랜덤 값을 생성한다")
    void shouldReturnRandomNumberBetweenZeroToNine() {
        RandomNumber randomNumber = new RandomNumber();
        assertThat(randomNumber.getValue()).isBetween(0, 9);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 false를 반환한다")
    void shouldReturnFalse() {
        RandomNumber randomNumber = new RandomNumber(3);
        boolean movable = randomNumber.equalsOrBiggerThanCondition();

        assertThat(movable).isFalse();
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 true를 반환한다")
    void shouldReturnTrue() {
        RandomNumber randomNumber = new RandomNumber(4);
        boolean movable = randomNumber.equalsOrBiggerThanCondition();

        assertThat(movable).isTrue();
    }
}