package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RacingTest {

    @DisplayName("요청된 양만큼 Car 생성 확인")
    @Test
    void car() {
        Racing racing = new Racing(3, 3);
        List<Car> cars = racing.getCars();
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }
}
