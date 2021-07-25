package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomServiceTest {
    @DisplayName("연속해서 호출하면 다른값이 나와야한다.")
    @Test
    void random() {
        RandomService randomService = new RandomService();
        assertThat(randomService.getRandomInt() + randomService.getRandomInt())
                .isNotEqualTo(randomService.getRandomInt() + randomService.getRandomInt());
    }

    @DisplayName("랜덤 값이 0-9 사이의 값인지 확인")
    @Test
    void random_range() {
        RandomService randomService = new RandomService();
        assertThat(randomService.getRandomInt()).isBetween(0, 9);
    }
}
