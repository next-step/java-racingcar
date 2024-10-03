package racing.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.game.RacingCalculator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarsTest {

    private Cars cars;
    private final List<Car> items = new ArrayList<>();

    @BeforeEach
    void setUp() {
        //given
        items.add(new Car(0));
        items.add(new Car(0));
        cars = new Cars(items);
    }

    @ParameterizedTest
    @DisplayName("자동차가 랜덤값이 4이상이면 간다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carGoAndStop_go(int number) {
        // when
        RacingCalculator racingCalculator = mock(RacingCalculator.class);
        when(racingCalculator.getRandomNumber()).thenReturn(number);

        // then
        cars.carGoAndStop(racingCalculator);
        assertThat(items).allMatch(car -> car.getPosition() == 1);
    }

    @ParameterizedTest
    @DisplayName("자동차가 랜덤값이 9이상이면 0미만 오류")
    @ValueSource(ints = {-1, 10, 11})
    void carGoAndStop_exception(int number) {
        // when
        RacingCalculator racingCalculator = mock(RacingCalculator.class);
        when(racingCalculator.getRandomNumber()).thenReturn(number);

        // then
        assertThatThrownBy(() -> cars.carGoAndStop(racingCalculator)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 랜덤값이 4미만이면 멈춘다.")
    void carGoAndStop_stop() {
        // when
        RacingCalculator racingCalculator = mock(RacingCalculator.class);
        when(racingCalculator.getRandomNumber()).thenReturn(3);

        // then
        cars.carGoAndStop(racingCalculator);
        assertThat(items).allMatch(car -> car.getPosition() == 0);
    }
}
