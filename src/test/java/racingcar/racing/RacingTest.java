package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.movepolicy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RacingTest {

    private MoveStrategy moveStrategy;
    private Cars cars;

    @BeforeEach
    void setUp() {
        moveStrategy = mock(MoveStrategy.class);
        var car = new Car(moveStrategy);
        cars = new Cars(List.of(car));
    }

    @Test
    void 자동차_목록을_받아_레이싱_객체를_생성한다() {
        Racing racing = new Racing(cars, 3);
        assertThat(racing).isNotNull();
    }

    @Test
    void 레이싱을_시작하면_라운드_횟수만큼_Cars의_moveAll이_호출된다() {
        Racing racing = new Racing(cars, 3);

        when(moveStrategy.move()).thenReturn(true);

        racing.start();

        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(3);
    }
}