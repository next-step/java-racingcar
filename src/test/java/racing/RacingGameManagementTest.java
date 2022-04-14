package racing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.DuplicatedCarException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingGameManagementTest {
    @Test
    @DisplayName("RacingGameManagement 객체에 동일차량을 중복 등록시 DuplicatedCarException 발생한다")
    void duplicatedCarTest() {

        assertThatExceptionOfType(DuplicatedCarException.class).isThrownBy(() -> {
            RacingGameManagement racingGameManagement = new RacingGameManagement();
            Car car = new Car();

            racingGameManagement.addCar(car.getId());
            racingGameManagement.addCar(car.getId());
        });


    }
}
