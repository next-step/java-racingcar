package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomMovingStrategyTest {

    @Test
    void 랜덤값이_4이상이면_참을_반환한다() {
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(random);

        assertThat(randomMovingStrategy.canMove()).isTrue();
    }
    @Test
    void 랜덤값이_4미만이면_거짓을_반환한다() {
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(random);

        assertThat(randomMovingStrategy.canMove()).isFalse();
    }

}