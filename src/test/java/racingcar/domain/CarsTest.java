package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {


    @Test
    @DisplayName("사용자가 입력한 값에 따라 자동차의 대수가 생성된다.")
    void create_test() {
        // Given
        String userInput = "5";
        // When
        Cars cars = new Cars(userInput);
        // Then
        assertEquals(5, cars.getCars().size());
    }

}