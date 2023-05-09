package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ThresholdCarDisplacementTest {
    int successCount = 4;
    int winNumber = 5;
    int loseNumber = 3;

    NumberGenerator winNumberGenerator;
    NumberGenerator loseNumberGenerator;
    CarDisplacement winCarDisplacement;
    CarDisplacement loseCarDisplacement;

    @BeforeEach
    void setUp() {
        winNumberGenerator = new SameNumberGenerator(winNumber);
        loseNumberGenerator = new SameNumberGenerator(loseNumber);
        winCarDisplacement = ThresholdCarDisplacement.create(winNumberGenerator, successCount);
        loseCarDisplacement = ThresholdCarDisplacement.create(loseNumberGenerator, successCount);
    }

    @Test
    @DisplayName("생성테스트")
    void create() {
        assertDoesNotThrow(() -> ThresholdCarDisplacement.create(winNumberGenerator, successCount));
    }

    @Test
    @DisplayName("numberGenerator가 threshold값을 넘어가면 앞으로 한 칸 움직인다")
    void overThreshold() {
        assertEquals(Position.MOVE.getPosition(), winCarDisplacement.displacement());
    }

    @Test
    @DisplayName("numberGenerator가 threshold값을 못 넘어가면 움직이지 않는다")
    void underThreshold() {
        assertEquals(Position.STOP.getPosition(), loseCarDisplacement.displacement());
    }
}
