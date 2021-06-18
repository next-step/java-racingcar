package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StadiumTest {
    private final Ready ready = new Ready();
    private final List<Car> cars = ready.createCars("a,b,c");
    private final Stadium stadium = new Stadium(cars, 3);

    @Test
    @DisplayName("stadium 생성 테스트")
    public void stadiumTest() {
        assertThat(stadium.getCars()).hasSize(3);
    }
}
