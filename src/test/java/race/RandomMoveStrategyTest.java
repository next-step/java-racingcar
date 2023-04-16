package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomMoveStrategyTest {
    @ParameterizedTest(name = "최소 조건이 {0}이고 maxBound가 {1}이면 결과는 {2}이다")
    @CsvSource(value = {"4:4:false", "0:5:true"}, delimiter = ':')
    void 최소조건과_max_bound를_설정해서_움직일지_말지를_결정할_수_있다(int minCondition, int maxBound, boolean expected) {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(minCondition, maxBound);
        assertThat(randomMoveStrategy.canMove()).isEqualTo(expected);
    }
}
