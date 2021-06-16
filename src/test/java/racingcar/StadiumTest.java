package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StadiumTest {
    private final Ready ready = new Ready();
    private final List<Car> cars = ready.createCars("a,b,c");
    private final int gameCount = 3;
    private Stadium stadium = new Stadium(cars, gameCount);

    @Test
    @DisplayName("stadium 생성 테스트")
    public void stadiumTest() {
        assertThat(stadium.getCars()).hasSize(3);
    }
}
