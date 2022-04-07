package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RoundTest {
    private final List<Car> mockCarList = new ArrayList<>();

    @BeforeEach
    public void init() {
        mockCarList.add(mock(Car.class));
        mockCarList.add(mock(Car.class));
        mockCarList.add(mock(Car.class));
        mockCarList.add(mock(Car.class));
    }

    @Test
    void play는_모든_car를_동작시킨다() {
        Round round = new Round(mockCarList);

        round.play();

        List<Car> carList = round.getCars();
        for (Car car : carList) {
            verify(car).act();
        }
    }
}
