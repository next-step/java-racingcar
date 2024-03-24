package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoveCountTest {

    @DisplayName("MoveCount 빈 생성자는 0을 값으로 갖는다.")
    @Test
    void constructor() {
        assertThat(new MoveCount().value()).isEqualTo(0);
    }

    @DisplayName("increase 메서드는 움직인 거리를 증가시킨다.")
    @Test
    void inscrease() {
        final MoveCount moveCount = new MoveCount();
        moveCount.increase();
        assertThat(moveCount.value()).isEqualTo(1);
    }
}
