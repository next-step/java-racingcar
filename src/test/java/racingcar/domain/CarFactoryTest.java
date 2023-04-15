package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.domain.fixture.ConstantsFixture.CAR_NAMES;

class CarFactoryTest {

    @Test
    @DisplayName("사용자가 입력한 값에 따라 자동차의 대수가 생성된다.")
    void create_test() {
        // Given & When
        CarFactory carFactory = new CarFactory(CAR_NAMES);
        // Then
        assertEquals(CAR_NAMES, carFactory.getCars().size());
    }

}