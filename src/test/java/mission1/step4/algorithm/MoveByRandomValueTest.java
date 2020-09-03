package algorithm;

import mission1.step4.algorithm.MoveByRandomValue;
import mission1.step4.algorithm.MoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MoveByRandomValueTest {

    @DisplayName("자동차 전진 알고리즘 체크")
    @ParameterizedTest(name="{index} {displayName} 제공값={0}, 결과={1}")
    @CsvSource({"1, false", "4, true", "3, false", "9, true"})
    public void carProgressCheck(int randomNumber, boolean result) {
        MoveStrategy strategy = new MoveByRandomValue();
        assertEquals(strategy.movable(randomNumber), result);
    }
}



