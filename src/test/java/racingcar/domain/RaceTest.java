package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    void 움직일_수_있는_상태라면_자동차는_전진한다() {
        Race race = new Race(new Cars(Arrays.asList(new Car("seung", 1), new Car("yeon", 5))), 5);
        List<List<Car>> histories = race.playGames(() -> true);
        assertThat(histories.get(histories.size() - 1).get(0).getDistance()).isEqualTo(6);
        assertThat(histories.get(histories.size() - 1).get(1).getDistance()).isEqualTo(10);
    }

    @Test
    void 움직일_수_없는_상태라면_자동차는_전진하지_않는다() {
        Race race = new Race(new Cars(Arrays.asList(new Car("seung", 1), new Car("yeon", 5))), 5);
        List<List<Car>> histories = race.playGames(() -> false);
        assertThat(histories.get(histories.size() - 1).get(0).getDistance()).isEqualTo(1);
        assertThat(histories.get(histories.size() - 1).get(1).getDistance()).isEqualTo(5);
    }
}
