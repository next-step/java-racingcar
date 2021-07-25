package racing.domain.game.vo.turn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TurnsTest {
    @DisplayName("Turn ctor Test")
    @ValueSource(ints = {
            1, 100
    })
    @ParameterizedTest
    public void ctorTest(int size) {
        Turns sizeCtorTurn = new Turns(size);

        List<Turn> turnList = new ArrayList<>();
        for (Iterator<Turn> iterator = sizeCtorTurn.iterator(); iterator.hasNext(); )
            turnList.add(iterator.next());
        Turns listCtorTurn = new Turns(turnList);

        assertThat(sizeCtorTurn.size())
            .isEqualTo(size);
        assertThat(listCtorTurn.size())
                .isEqualTo(size);
    }

    @DisplayName("Turn ctor InvalidInputException Test")
    @ValueSource(ints = {
            0, -1, -100
    })
    @ParameterizedTest
    public void ctorInvalidInputExceptionTest(int size) {
        assertThatThrownBy(() ->
            new Turns(size)
        ).isInstanceOf(InvalidInputException.class);
    }

    @DisplayName("waitingTurns와 endedTurns 테스트")
    @ValueSource(ints = {
            1, 100, 1000
    })
    @ParameterizedTest
    public void turnFilterTest(int size) {
        Turns turns = new Turns(size);

        assertThat(turns.waitingTurns().size())
                .isEqualTo(size);
        assertThat(turns.endedTurns().size())
                .isEqualTo(0);
    }
}