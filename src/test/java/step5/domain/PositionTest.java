package step5.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position("");
    }

    @DisplayName("생성된 포지션이 같은지 확인한다")
    @Test
    void samePosition() {
        assertThat(position).isEqualTo(new Position(""));
    }

    @DisplayName("자동차가 전진한다")
    @Test
    void forwardPosition() {
        Position forwardByMinNumber = position.move(4);
        Position forwardByMaxNumber = position.move(9);

        assertAll(() -> assertThat(forwardByMinNumber.getPosition()).isEqualTo("-"),
                  () -> assertThat(forwardByMaxNumber.getPosition()).isEqualTo("--"));

    }

    @DisplayName("자동차가 움직이지 않는다")
    @Test
    void stopPosition() {
        Position stopByMinNumber = position.move(0);
        Position stopByMaxNumber = position.move(3);

        assertAll(() -> assertThat(stopByMinNumber.getPosition()).isEqualTo(""),
                  () -> assertThat(stopByMaxNumber.getPosition()).isEqualTo(""));

    }

}
