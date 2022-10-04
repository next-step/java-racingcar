package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameRuleTest {

    @ParameterizedTest
    @CsvSource(value = {"1:false", "5:true"}, delimiter = ':')
    public void isGoStraight_4이상은직진이다(int input, boolean expected) {
        Assertions.assertThat(GameRule.isGoStraight(input)).isEqualTo(expected);
    }
}
