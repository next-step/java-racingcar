package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RoundTest {
    private final List<Car> mockCarList = new ArrayList<>();
    private Cars mockCars;

    @BeforeEach
    public void init() {
        mockCars = mock(Cars.class);
        mockCarList.add(mock(Car.class));
        mockCarList.add(mock(Car.class));
        mockCarList.add(mock(Car.class));
        mockCarList.add(mock(Car.class));
    }

    @Test
    void play는_cars를_동작시킨다() {
        Round round = new Round(mockCars);

        round.play();

        Cars cars = round.getCars();
        verify(cars).act();
    }
}
