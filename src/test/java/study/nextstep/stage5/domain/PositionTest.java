package study.nextstep.stage5.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    public void testMoveForward() {
        Position position = new Position();
        position.run(new Random(){
            @Override
            public int nextInt(int bound) {
                return bound - 1;
            }
        });
        assertThat(position.getValue()).isEqualTo(2);
    }

    @Test
    public void testNotMove() {
        Position position = new Position();
        position.run(new Random(){
            @Override
            public int nextInt(int bound) {
                return 0;
            }
        });
        assertThat(position.getValue()).isEqualTo(1);
    }
}
