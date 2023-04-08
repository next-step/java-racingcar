package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {


    @Test
    @DisplayName("사용자가 입력한 값에 따라 자동차의 대수가 생성된다.")
    void create_test() {
        // Given
        int userInput = 5;
        // When
        Factory factory = new Factory(userInput);
        // Then
        assertEquals(5, factory.getCars().size());
    }

}