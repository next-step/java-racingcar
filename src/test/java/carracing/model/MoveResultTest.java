package carracing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoveResultTest {

    @ParameterizedTest
    @CsvSource(value = { "true: 1", "false:0" }, delimiter = ':')
    void applyMoveResult_결과에맞게기록한다(boolean condition, int expected) {
        MoveResult moveResult = new MoveResult();
        moveResult = moveResult.applyMoveResult(condition);
        Assertions.assertThat(moveResult.getStraightCount()).isEqualTo(expected);
    }
}
