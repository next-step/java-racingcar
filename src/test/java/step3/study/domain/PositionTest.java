package step3.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionTest {

    @Test
    @DisplayName("포지션 증가 테스트")
    void increaseTest() {
        Position position = new Position(0);
        position.increase();
        assertThat(position).isEqualTo(new Position(1));
    }
}