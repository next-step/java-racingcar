package racingcar.domain.movable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomMovableTest {

    @Test
    @DisplayName("랜덤값이 4 이상이면 움직일 수 있다")
    void name() {
        Movable movable = new RandomMovable(() -> 4);

        Assertions.assertThat(movable.canMove()).isTrue();
    }

    @Test
    @DisplayName("랜덤값이 3 이하면 움직일 수 없다")
    void name2() {
        Movable movable = new RandomMovable(() -> 3);

        Assertions.assertThat(movable.canMove()).isFalse();

    }
}
