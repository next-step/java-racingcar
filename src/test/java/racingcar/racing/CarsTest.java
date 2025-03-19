package racingcar.racing;

import org.junit.jupiter.api.Test;
import racingcar.movepolicy.MoveStrategy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarsTest {

    @Test
    void 자동차_목록을_받아_Cars_객체를_생성한다() {
        Car car = mock(Car.class);
        Cars cars = new Cars(List.of(car));

        assertNotNull(cars);
    }

    @Test
    void 자동차를_추가할_때_Car_객체가_Null이면_예외가_발생한다() {
        Car car = mock(Car.class);
        Cars cars = new Cars(List.of(car));

        assertThrows(IllegalArgumentException.class, () -> cars.add(null));
    }

    @Test
    void moveAll이_호출되면_Cars_객체에_있는_Car_객체의_play가_반드시_한_번_호출된다() {
        Car car = mock(Car.class);
        Cars cars = new Cars(List.of(car));

        cars.moveAll();

        verify(car, times(1)).play();
    }

    @Test
    void toString을_호출하면_Cars_객체에_있는_Car_객체의_거리만큼_하이픈이_출력된다() {
        MoveStrategy moveStrategy = mock(MoveStrategy.class);
        Car car1 = new Car(moveStrategy);
        Car car2 = new Car(moveStrategy);
        Car car3 = new Car(moveStrategy);
        Cars cars = new Cars(List.of(car1, car2, car3));

        when(moveStrategy.move()).thenReturn(true);

        cars.moveAll();

        String result = cars.toString();

        assertEquals("-\n-\n-\n", result);
    }
}