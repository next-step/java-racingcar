package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("자동차 경주 - Round 테스트")
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
