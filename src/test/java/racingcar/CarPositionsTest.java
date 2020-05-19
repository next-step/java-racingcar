package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionsTest {

    @DisplayName("선두 자동차는 1개 이상이다")
    @Test
    void getLeaders() {
        List<CarPosition> positions = Arrays.asList(
                new CarPosition("car1", 1),
                new CarPosition("car2", 2),
                new CarPosition("car3", 3),
                new CarPosition("car4", 3)
        );

        CarPositions carPositions = new CarPositions(positions);
        List<String> leaders = carPositions.getLeaders();

        assertThat(leaders.size()).isEqualTo(2);
    }
}
