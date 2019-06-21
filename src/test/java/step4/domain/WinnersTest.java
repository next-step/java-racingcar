package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    private CarNames testNames = CarNames.from("car1,car2,car3");
    private Cars testCars = Cars.of(testNames);
    private Cars movedCars = testCars.move();
    private Winners winners = Winners.from(movedCars);

    @Test
    void 한_라운드가_끝나고_가장_많이_전진한_자동차들을_찾는다() {
        assertThat(winners).isNotNull();
    }

    @Test
    void 선정된_우승자들의_position은_같다() {
        assertThat(winners.getWinners().stream()
                .map(Car::getPosition)
                .distinct()
                .count()).isEqualTo(1);
    }
}
