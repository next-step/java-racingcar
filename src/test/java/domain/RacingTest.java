package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private static final MovingStrategy movingStrategy = new MovingStrategy();

    @Test
    void 자동차_이름갯수만큼_생성() {
        List<CarName> carNameList = new ArrayList<>(Arrays.asList(new CarName("car1"), new CarName("car2"), new CarName("car3")));
        Racing racing = new Racing(carNameList);
        assertThat(racing.getCars()).hasSize(3);
    }

    @Test
    void 자동차_경주() {
        List<CarName> carNames = new ArrayList<>();
        carNames.add(new CarName("a,b"));

        Racing racing = new Racing(carNames);
        racing.race(movingStrategy);
        assertThat(racing.getWinners()).isNotNull();
    }
}
