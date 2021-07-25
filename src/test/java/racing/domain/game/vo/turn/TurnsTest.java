package racing.domain.game.vo.turn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TurnsTest {
    @DisplayName("Turn ctor Test")
    @ValueSource(ints = {
            1, 100
    })
    @ParameterizedTest
    public void ctorTest(int size) {
        assertThat(new Turns(size).size())
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
}