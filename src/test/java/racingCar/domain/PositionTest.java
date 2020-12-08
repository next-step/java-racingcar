package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    private Position position;
    private Position comparePos1;
    private Position comparePos2;

    @BeforeEach
    void setUp() {
        position = new Position();
        comparePos1 = new Position();
        comparePos2 = new Position();
    }

    @Test
    @DisplayName("초기값 test")
    void initialPosition() {
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 test")
    void movePosition() {
        position.move();
        position.move();
        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("position 비교 test(기준 > 비교 : return 1)")
    void returnOne() {
        comparePos1.move();
        comparePos1.move();
        comparePos2.move();
        assertThat(comparePos1.compareTo(comparePos2)).isEqualTo(1);
    }

    @Test
    @DisplayName("position 비교 test(기준 = 비교 : return 0)")
    void returnZero() {
        comparePos1.move();
        comparePos1.move();
        comparePos2.move();
        comparePos2.move();
        assertThat(comparePos1.compareTo(comparePos2)).isEqualTo(0);
    }

    @Test
    @DisplayName("position 비교 test(기준 < 비교 : return -1)")
    void returnMinusOne() {
        comparePos1.move();
        comparePos2.move();
        comparePos2.move();
        assertThat(comparePos1.compareTo(comparePos2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Position 비교 test")
    void equalsTest() {
        comparePos1.move();
        comparePos2.move();
        assertThat(comparePos1.equals(comparePos2)).isEqualTo(true);
    }


}
