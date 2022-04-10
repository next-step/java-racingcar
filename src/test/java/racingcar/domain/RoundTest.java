package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RoundTest {
    private Cars mockCars;

    @BeforeEach
    public void init() {
        mockCars = mock(Cars.class);
    }

    @Test
    void play는_cars를_동작시킨다() {
        Round round = new Round(mockCars);

        round.play();

        Cars cars = round.getCars();
        verify(cars).act();
    }
}
