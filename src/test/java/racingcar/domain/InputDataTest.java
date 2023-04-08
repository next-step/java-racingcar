package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputDataTest {

        @Test
        @DisplayName("입력받은 자동차 대수와 시도 횟수를 저장한다.")
        void inputData_test() {
            // Given
            int carCount = 5;
            int roundCount = 10;

            // When
            InputData inputData = new InputData(carCount, roundCount);

            // Then
            assertEquals(5, inputData.getCarCount());
            assertEquals(10, inputData.getRoundCount());
        }

}