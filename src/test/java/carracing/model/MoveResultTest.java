package carracing.model;

import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoveResultTest {

    @ParameterizedTest
    @CsvSource(value = { "true:false" }, delimiter = ':')
    void applyMoveResult_움직였을때의_결과를확인한다(boolean movable, boolean expected) {
        MoveResult beforeMove = new MoveResult();
        MoveResult afterMove = beforeMove.applyMoveResult(movable);
        Assertions.assertThat(Objects.equals(beforeMove, afterMove)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "false:true" }, delimiter = ':')
    void applyMoveResult_멈췄을때의_결과를확인한다(boolean movable, boolean expected) {
        MoveResult beforeMove = new MoveResult();
        MoveResult afterMove = beforeMove.applyMoveResult(movable);
        Assertions.assertThat(Objects.equals(beforeMove, afterMove)).isEqualTo(expected);
    }
}
