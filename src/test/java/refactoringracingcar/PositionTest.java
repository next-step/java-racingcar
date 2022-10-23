package refactoringracingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactoringracingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    Position position;

    @BeforeEach
    void setUp() {
        position = new Position();
    }

    @DisplayName("전진테스트")
    @Test
    void moveCarUnitTest_01() {
        assertThat(position.moveCarUnit(true)).isEqualTo(1);
    }

    @DisplayName("멈춤테스트")
    @Test
    void moveCarUnitTest_02() {
        assertThat(position.moveCarUnit(false)).isEqualTo(0);
    }

}
