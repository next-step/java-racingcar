package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private final MoveStrategy alwaysMoveStrategy = () -> true;

    @Test
    void 자동차_목록을_받아_레이싱_객체를_생성한다() {
        List<Car> cars = List.of(new Car(alwaysMoveStrategy));
        Racing racing = new Racing(cars);
        assertThat(racing).isNotNull();
    }

    @Test
    void 라운드가_한_번_진행되면_Car_play가_반드시_호출된다() {
        List<Car> cars = List.of(new Car(alwaysMoveStrategy));
        Racing racing = new Racing(cars);
        racing.playRound();
        assertThat(cars.get(0).getDistance()).isEqualTo(1);
    }
}