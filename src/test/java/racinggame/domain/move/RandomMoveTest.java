package racinggame.domain.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveTest {

    @DisplayName("생성한 random 값은 조건에 따라 boolean 값을 return.")
    @Test
    void isMove() {
        assertThat(new RandomMove().isMove()).isInstanceOf(Boolean.class);
    }
}