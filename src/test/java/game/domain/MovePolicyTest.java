package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovePolicyTest {

    @DisplayName("움직일 수 있다면 true를 반환")
    @Test
    public void movable_shouldReturnTrue() {
        MovePolicy fakeSuccessMovePolicy = new MovePolicy() {
            @Override
            public boolean isMovable() {
                return true;
            }
        };
        assertThat(fakeSuccessMovePolicy.isMovable()).isEqualTo(true);
    }

    @DisplayName("움직일 수 있다면 false를 반환")
    @Test
    public void movable_shouldReturnFalse() {
        MovePolicy fakeFailMovePolicy = new MovePolicy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        };
        assertThat(fakeFailMovePolicy.isMovable()).isEqualTo(false);
    }
}
