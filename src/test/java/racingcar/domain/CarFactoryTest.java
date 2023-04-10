package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    private static final int CAR_COUNT = 5;

    @Test
    @DisplayName("사용자가 입력한 값에 따라 자동차의 대수가 생성된다.")
    void create_test() {
        // Given & When
        CarFactory carFactory = new CarFactory(CAR_COUNT);
        // Then
        assertEquals(CAR_COUNT, carFactory.getCars().size());
    }

}