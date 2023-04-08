package step3.strategy.draw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DashDrawStrategyTest {

    @DisplayName("자동차의 위치 출력 전략 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---", "4:----", "5:-----"}, delimiter = ':')
    public void allowMoveTest(int input, String resultString) {
        DashDrawStrategy drawStrategy = DashDrawStrategy.getInstance();

        assertThat(drawStrategy.draw(input)).isEqualTo(resultString);

    }
}