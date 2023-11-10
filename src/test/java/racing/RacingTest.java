package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @DisplayName("레이싱 가장 멀리간 거리 확인 테스트")
    @Test
    void 가장먼거리() {
        // given
        String[] carNames = {"car1", "car2", "car3"};
        List<Integer> distanceList = new ArrayList<>(Arrays.asList(new Integer[]{1, 4, 5}));
        Racing racing = new Racing(carNames, 3);

        // when
        racing.race(distanceList);
        racing.showWinner();

        // then
        assertThat(racing.getLongestDistance()).isEqualTo(3);
    }

    @DisplayName("우승자가 1명일 경우 우승자를 확인하는 테스트")
    @Test
    void 우승자_1명() {
        // given
        String[] carNames = {"car1", "car2", "car3"};
        List<Integer> distanceList = new ArrayList<>(Arrays.asList(new Integer[]{1, 4, 1}));
        Racing racing = new Racing(carNames, 3);

        // when
        racing.race(distanceList);
        racing.showWinner();

        // then
        assertThat(racing.getWinners().size()).isEqualTo(1);
        assertThat(racing.getWinners().contains("car2")).isTrue();
    }

    @DisplayName("우승자가 2명 이상일 경우 우승자를 확인하는 테스트")
    @Test
    void 우승자_2명이상() {
        // given
        String[] carNames = {"car1", "car2", "car3"};
        List<Integer> distanceList = new ArrayList<>(Arrays.asList(new Integer[]{1, 4, 4}));
        Racing racing = new Racing(carNames, 3);

        // when
        racing.race(distanceList);
        racing.showWinner();

        // then
        assertThat(racing.getWinners().size()).isEqualTo(2);
        assertThat(racing.getWinners().contains("car2")).isTrue();
        assertThat(racing.getWinners().contains("car3")).isTrue();
    }
}
