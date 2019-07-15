package homework.week1.racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    void 랜덤숫자받는생성자이용한movable() {
        RandomNumberGenerator move = new RandomNumberGenerator(4);
        RandomNumberGenerator stop = new RandomNumberGenerator(3);
        assertThat(move.movable()).isTrue();
        assertThat(stop.movable()).isFalse();
    }
}
