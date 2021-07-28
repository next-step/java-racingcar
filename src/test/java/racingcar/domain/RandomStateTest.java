package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomStateTest {
    @DisplayName("연속해서 호출하면 다른값이 나와야한다.")
    @Test
    void getRandomInt() {
        RandomState randomState = new RandomState();
        assertThat(randomState.getRandomInt() + randomState.getRandomInt())
                .isNotEqualTo(randomState.getRandomInt() + randomState.getRandomInt());
    }

    @DisplayName("랜덤 값이 0-9 사이의 값인지 확인")
    @Test
    void getRandomInt_range() {
        RandomState randomState = new RandomState();
        assertThat(randomState.getRandomInt()).isBetween(0, 9);
    }
}
