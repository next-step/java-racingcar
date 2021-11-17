package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCounterTest {
    @Test
    @DisplayName("MoveCounter 생성자 테스트")
    public void constructor() {
        assertThat(new MoveCounter(3)).isEqualTo(new MoveCounter(3));
    }

    @Test
    @DisplayName("moveCount는 음수 값을 가질 수 없습니다.")
    public void 음수_값인지_테스트(){
        assertThatThrownBy(() -> {
            new MoveCounter(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("moveCount를 1 증가 시킨다.")
    public void move() {
        MoveCounter moveCounter = new MoveCounter();
        assertThat(moveCounter.move()).isEqualTo(new MoveCounter(1));
    }

    @Test
    @DisplayName("moveCount와 maxCount값이 같은지 테스트")
    public void isMoveCountEqualMaxCount() {
        MoveCounter moveCounter = new MoveCounter();
        moveCounter.move();
        assertThat(moveCounter.isMoveCountEqualMaxCount(1)).isTrue();
    }
}
