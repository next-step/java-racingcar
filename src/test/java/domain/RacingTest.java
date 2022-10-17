package domain;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;

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
        carNames.add(new CarName("a"));
        carNames.add(new CarName("b"));

        Racing racing = new Racing(carNames);
        racing.race(movingStrategy);

        List<String> winners = racing.getWinners();

        for (int i = 0; i < winners.size(); i ++) {
            String winner = winners.get(i);
            if (winner.equals("a")) {
                assertThat(winner).isEqualTo("a");
            }  else if (winner.equals("b")) {
                assertThat(winner).isEqualTo("b");
            } else {
                assertThat(winner).isEqualTo("a, b");
            }
        }
    }
}
