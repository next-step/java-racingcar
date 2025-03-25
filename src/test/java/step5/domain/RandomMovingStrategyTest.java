package step5.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingStrategyTest {

    @Test
    void 랜덤값이_4면_참을_반환() {
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        });

        assertThat(randomMovingStrategy.movable()).isTrue();
    }

    @Test
    void 랜덤값이_3이면_거짓을_반환() {
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        });

        assertThat(randomMovingStrategy.movable()).isFalse();
    }
}
