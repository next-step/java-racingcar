package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @Test
    @DisplayName("주어진 횟수 만큼 레이싱")
    void testRaceComplete() {
        // given
        int raceCount = 5;
        int count = 0;
        Cars cars = new Cars(3);
        CarRacing racing = new CarRacing(cars, new RandomMoveStrategy(0, 9, 4), raceCount);
        // when
        while (!racing.isComplete()) {
            racing.race(dist -> {});
            count++;
        }
        // then
        assertThat(racing.isComplete()).isTrue();
        assertThat(count).isEqualTo(raceCount);
    }

    @Test
    @DisplayName("레이싱 미완료")
    void testRaceNotComplete() {
        // given
        Cars cars = new Cars(3);
        CarRacing racing = new CarRacing(cars, new RandomMoveStrategy(0, 9, 4), 5);
        // when
        racing.race(dist -> {});
        // then
        assertThat(racing.isComplete()).isFalse();
    }
}
