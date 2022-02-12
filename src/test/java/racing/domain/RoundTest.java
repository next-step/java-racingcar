package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    void 라운드횟수만큼_라운드를_실행시킨다() {
        Round round = new Round(2);
        RandomMoveRule moveRule = new RandomMoveRule();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a", moveRule));
        cars.add(new Car("b", moveRule));

        round.play(cars);

        assertThat(round.getRacingResult().getRacingResult().size()).isEqualTo(2);
    }
}
