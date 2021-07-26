package racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AlwaysMoveStrategyTest {

    @Test
    @DisplayName("AlwaysMoveStrategy 전략의 movable 함수는 항상 true를 리턴한다.")
    void movable(){
        AlwaysMoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();
        assertThat(alwaysMoveStrategy.isMovable()).isTrue();
    }
}