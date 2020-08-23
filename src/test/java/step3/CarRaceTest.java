package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.car.CarFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarRaceTest {

    @DisplayName("레이스 진행시 자동차의 대수, 시행횟수가 1 미만의 값을 가질때 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource({"0, 0", "0, -1", "-1, 0","-1, -1"})
    public void insertInappositeValue(int carNumber, int executionNumber) {
        assertThrows(IllegalArgumentException.class, () -> CarRace.getInstance(carNumber, executionNumber));
    }
}
