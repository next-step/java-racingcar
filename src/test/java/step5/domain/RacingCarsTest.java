package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingCar 테스트")
class RacingCarsTest {
    private List<Car> cars = Arrays.asList(new Car("Car-A"), new Car("Car-B"), new Car("Car-C"));
    private RacingCars racingCars = new RacingCars(cars);

    @DisplayName("차량목록 확인")
    @Test
    void getCars() {
        assertThat(racingCars.getCars().get(0)).isInstanceOf(Car.class);
    }

    @DisplayName("이동조건에 따른 이동")
    @ParameterizedTest
    @ValueSource(ints = {3, 7})
    void moveableCheck(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            racingCars.moveableCheck(() -> true);
        }
        assertThat(racingCars.getCars().get(0).getPosition()).isEqualTo(moveCount);
    }

    @DisplayName("우승자 계산")
    @Test
    void getWinCarNames() {
        racingCars.getCars().get(0).move();
        assertThat(racingCars.getWinCarNames()).contains("Car-A");
    }
}
