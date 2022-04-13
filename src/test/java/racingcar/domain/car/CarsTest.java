package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.CarActionStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("자동차 경주 - Cars 테스트")
class CarsTest {
    private final List<Car> mockCarList = new ArrayList<>();
    private final List<Integer> carPositionList = List.of(5, 1, 2, 4, 3);
    private Cars cars;

    @BeforeEach
    public void init() {
        for (int i = 0; i < 5; i++) {
            mockCarList.add(mock(Car.class));
        }
        cars = new Cars(mockCarList);
    }

    @Test
    void act는_자동차_전체를_동작시킨다() {
        cars.act();

        mockCarList.forEach(car -> verify(car).act(any(CarActionStrategy.class)));
    }

    @Test
    void getCarPositions은_자동차들의_현재위치_리스트를_반환한다() {
        for (int i = 0; i < mockCarList.size(); i++) {
            when(mockCarList.get(i).getPosition()).thenReturn(carPositionList.get(i));
        }

        List<Integer> positions = cars.getCarPositions();

        for (int i = 0; i < positions.size(); i++) {
            assertThat(positions.get(i)).isEqualTo(carPositionList.get(i));
        }
    }
}
