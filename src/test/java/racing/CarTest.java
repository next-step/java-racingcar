package racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 생성 기능")
    public void writingMethodName() throws Exception {
        // when
        Car car = Car.defaultOf();

        // then
        Assertions.assertNotNull(car);
    }
}
