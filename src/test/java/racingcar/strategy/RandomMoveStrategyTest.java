package racingcar.strategy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("랜덤 MoveStrategy 테스트")
class RandomMoveStrategyTest {

    @DisplayName("랜덤 객체를 가지고 초기화 한다.")
    @Test
    void init() {
        assertThat(new RandomMoveStrategy(new Random())).isNotNull();
    }

    @DisplayName("랜덤 객체가 null 일 경우 예외를 발생시킨다.")
    @Test
    void initWithNull() {
        assertThatThrownBy(() -> new RandomMoveStrategy(null)).isInstanceOf(IllegalArgumentException.class);
    }

}