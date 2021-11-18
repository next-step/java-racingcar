package racingcargamefinal.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveValueTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void create(int value) {
        MoveValue moveValue = new MoveValue(value);
        assertThat(moveValue).isInstanceOf(MoveValue.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void createFail(int value) {
        assertThatThrownBy(() -> {
            new MoveValue(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("move value 는 0 ~ 9입니다.");
    }

    @Test
    void canMove() {
        assertThat(new MoveValue(4).canMove()).isTrue();
    }

    @Test
    void canMoveFail() {
        assertThat(new MoveValue(3).canMove()).isFalse();
    }

}
