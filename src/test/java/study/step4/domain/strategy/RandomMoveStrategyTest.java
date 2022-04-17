package study.step4.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("랜덤 이동 전략 테스트")
class RandomMoveStrategyTest {

    @DisplayName("4이상일 경우 True 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:False", "3:False", "4:True", "9:True"}, delimiter = ':')
    void isMovable(int input, boolean result) {
        MoveStrategy moveStrategy = new TestMoveStrategy(input);
        boolean movable = moveStrategy.isMovable();

        assertThat(movable).isEqualTo(result);
    }
}