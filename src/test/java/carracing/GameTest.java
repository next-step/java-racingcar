package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @DisplayName("배정받은 자동차 간 한 레이스 경주 테스트, 0 or 1")
    @Test
    void race() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(new Car());
        }

        List<Integer> race = Game.race(cars);
        assertThat(race).containsAnyOf(0,1);
    }

}
