package study.racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    private Position p;

    @BeforeEach
    void 포지션초기화(){
        p = new Position();
    }

    @Test
    void increaseDownTest() {
        assertThat(p.increase(3)).isEqualTo(new Position(0));
    }

    @Test
    void increaseUpTest() {
        assertThat(p.increase(4)).isEqualTo(new Position(1));
    }

    @Test
    void isBiggerThan() {
        p = new Position(3);
        assertThat(p.isBiggerThan(new Position(3))).isTrue();

    }
}