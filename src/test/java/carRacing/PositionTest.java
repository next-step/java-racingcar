package carRacing;

import carRacing.model.RacingCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("위치값에 음수 입력시 에러 발생 테스트")
    void inputPosition_negative() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RacingCar racingCar = new RacingCar("ktan", -3);
        });

        System.out.print(exception.getMessage());
    }
}
