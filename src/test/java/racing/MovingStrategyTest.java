package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.MovingStrategy;
import racing.domain.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Moving Strategy 테스트")
public class MovingStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"4:true", "3:false"}, delimiter = ':')
    @DisplayName("랜덤 이동 전략 테스트")
    void movingStrategyTest(int input, boolean expected) {

        MovingStrategy move = RandomMovingStrategy.isMove(input);

        assertThat(move.isMove()).isEqualTo(expected);
    }
}
