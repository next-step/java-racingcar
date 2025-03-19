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
        Racing racing = new Racing(cars, 1);
        assertThat(racing).isNotNull();
    }

    @Test
    void 라운드가_한_번_진행되면_Car_play가_반드시_호출된다() {
        MoveStrategy moveStrategy = mock(MoveStrategy.class);
        Car car = new Car("pobi", moveStrategy);
        Cars cars = new Cars(List.of(car));
        Racing racing = new Racing(cars, 1);

        when(moveStrategy.move()).thenReturn(true);

        racing.start();

        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(1);
    }

    @Test
    void toString을_호출하면_라운드마다_자동차_이름별_전진_거리와_최종_우승자가_출력된다() {
        MoveStrategy moveStrategy = mock(MoveStrategy.class);
        Car car1 = new Car("pobi", moveStrategy);
        Car car2 = new Car("poci", moveStrategy);
        Car car3 = new Car("podi", moveStrategy);
        Cars cars = new Cars(List.of(car1, car2, car3));
        Racing racing = new Racing(cars, 1);

        when(moveStrategy.move()).thenReturn(true);

        racing.start();

        assertThat(racing.toString()).isEqualTo(
                "pobi : -\npoci : -\npodi : -\n\npobi, poci, podi가 최종 우승했습니다.");
    }
}