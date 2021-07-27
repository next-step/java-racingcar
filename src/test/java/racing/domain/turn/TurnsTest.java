package racing.domain.turn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TurnsTest {
    @DisplayName("ctor Test")
    @ValueSource(ints = {
            1, 100
    })
    @ParameterizedTest
    public void ctorTest(int size) {
        Turns sizeCtorTurn = new Turns(size);

        assertThat(sizeCtorTurn.size())
                .isEqualTo(size);
    }

    @DisplayName("ctor InvalidInputException Test")
    @ValueSource(ints = {
            0, -1, -100
    })
    @ParameterizedTest
    public void ctorInvalidInputExceptionTest(int size) {
        assertThatThrownBy(() ->
            new Turns(size)
        ).isInstanceOf(InvalidInputException.class);
    }

    @DisplayName("lastTurn Test")
    @ValueSource(ints = {
            1, 100, 1000
    })
    @ParameterizedTest
    public void lastTurnTest(int size) {
        Turns turns = new Turns(size);

        assertThat(turns.lastTurn())
                .isNotNull();
    }
}