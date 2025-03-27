package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.participant.Car;
import racingcar.participant.CarName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    void 참여할_자동차_목록을_받아_레이싱_객체를_생성한다() {
        Racing racing = new Racing(List.of(new Car(new CarName("a"))));
        assertThat(racing).isNotNull();
    }

    @Test
    void 라운드가_한_번_진행되면_Car_play가_반드시_호출된다() {
        Racing racing = new Racing(List.of(new Car(new CarName("b"))));

        racing.playRound();
        assertThat(racing.getCars().get(0).getPlayCount()).isEqualTo(1);
    }

    @Test
    void 가장_멀리_간_차_목록을_가져올_수_있다() {
        Racing racing = new Racing(List.of(
                new Car(new CarName("a"), 5, 0),
                new Car(new CarName("b"), 10, 0),
                new Car(new CarName("c"), 10, 0)
        ));

        assertThat(racing.getFarthestCars()).hasSize(2);
    }
}