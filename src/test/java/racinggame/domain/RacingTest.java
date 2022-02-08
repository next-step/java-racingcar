package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @DisplayName("자동차가 잘 등록되었는지 확인")
    @Test
    void testRegisterCars() {
        List<String> carNames = Arrays.asList("123", "456", "789");
        Racing racing = new Racing();
        racing.registerCars(carNames);

        List<Car> expected = Arrays.asList(new Car("123"), new Car("456"), new Car("789"));
        List<Car> actual = racing.getCarInfo();

        assertThat(actual).isEqualTo(expected);
    }
}