package racingcar.racing;

import org.junit.jupiter.api.Test;
import racingcar.movepolicy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RacingTest {

    @Test
    void 자동차_목록을_받아_레이싱_객체를_생성한다() {
        MoveStrategy moveStrategy = mock(MoveStrategy.class);
        Car car = new Car("pobi", moveStrategy);
        Cars cars = new Cars(List.of(car));
        Racing racing = new Racing(cars);
        assertThat(racing).isNotNull();
    }

    @Test
    void 라운드가_한_번_진행되면_Car_play가_반드시_호출된다() {
        MoveStrategy moveStrategy = mock(MoveStrategy.class);
        Car car = new Car("pobi", moveStrategy);
        Cars cars = new Cars(List.of(car));
        Racing racing = new Racing(cars);

        when(moveStrategy.move()).thenReturn(true);

        racing.start();

        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(1);
    }
}