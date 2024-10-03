package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveTest {

    @Test
    @DisplayName("자동차 전진에 사용할 랜덤 값이 4 이상일 때 true 반환한다.")
    void 랜덤값_4_이상() {
        boolean movable = RandomMove.getInstance().movable(1);
        assertThat(movable).isFalse();
        movable = RandomMove.getInstance().movable(4);
        assertThat(movable).isTrue();
    }

    @Test
    @DisplayName("자동차 전진에 사용할 랜덤 값이 0~9 사이이다.")
    void 랜덤값_0_9_사이() {
        assertThat(RandomMove.getInstance().getRandomValue()).isBetween(0, 9);
    }

}