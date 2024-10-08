package racing.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.fake.FakeRandomCalculator;
import racing.domain.game.Calculator;
import racing.domain.game.RacingRandomCalculator;

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
        items.add(new Car( "bmw", 0));
        items.add(new Car( "volvo",0));
        cars = new Cars(items);
    }

    @Test
    @DisplayName("자동차가 랜덤값이 4이상이면 간다.")
    void carGoAndStop_go() {
        Calculator fakeRandom = new FakeRandomCalculator();
        cars.carGoAndStop(fakeRandom);

        assertThat(items).allMatch(car -> car.getPosition() == 1);
    }

    @ParameterizedTest
    @DisplayName("자동차가 랜덤값이 9이상이면 0미만 오류")
    @ValueSource(ints = {-1, 10, 11})
    void carGoAndStop_exception(int number) {

        RacingRandomCalculator racingRandomCalculator = mock(RacingRandomCalculator.class);
        when(racingRandomCalculator.getRandomNumber()).thenReturn(number);

        assertThatThrownBy(() -> cars.carGoAndStop(racingRandomCalculator)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 랜덤값이 4미만이면 멈춘다.")
    void carGoAndStop_stop() {
        //given
        RacingRandomCalculator racingRandomCalculator = mock(RacingRandomCalculator.class);
        when(racingRandomCalculator.getRandomNumber()).thenReturn(3);

        // when
        cars.carGoAndStop(racingRandomCalculator);

        //then
        assertThat(items).allMatch(car -> car.getPosition() == 0);
    }
}
