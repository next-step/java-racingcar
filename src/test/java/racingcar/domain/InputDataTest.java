package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputDataTest {

    private static final int CAR_COUNT = 5;
    private static final int ROUND_COUNT = 10;

    @Test
    @DisplayName("입력받은 자동차 대수와 시도 횟수를 저장한다.")
    void inputData_test() {
        // Given & When
        InputData inputData = new InputData(CAR_COUNT, ROUND_COUNT);

        // Then
        assertAll(
                () -> assertEquals(CAR_COUNT, inputData.getCarCount()),
                () -> assertEquals(ROUND_COUNT, inputData.getRoundCount())
        );
    }

}