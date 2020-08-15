package racing.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyTest {

    MoveStrategy defaultStrategy;
    RacingMoveStategy randomStrategy;

    @BeforeEach
    public void setUp() {
        defaultStrategy = new DefaultMoveStategy();
        randomStrategy = new RacingMoveStategy();
    }

    @DisplayName("기본전략으로 1칸 움직이기")
    @Test
    public void 칸1_움직이기() {
        assertThat(defaultStrategy.move()).isEqualTo(1);
    }

    @DisplayName("레이싱전략으로 10보다 작은 랜덤값 가져오기")
    @Test
    public void 랜덤값_가져오기() {
        assertThat(randomStrategy.getRandomValue()).isLessThan(10);
    }

    @DisplayName("레이싱전략으로 4보다 작은지 판단k")
    @ParameterizedTest
    @CsvSource(value={"3:false", "5:true", "8:true"}, delimiter = ':')
    public void 작은지_판단_4보다(int value, boolean expected) {
        assertThat(randomStrategy.isGreaterThanMinimum(value)).isEqualTo(expected);
    }
}
