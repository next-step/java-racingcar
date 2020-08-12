package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.RacingCars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        final List<Car> cars = Arrays.asList(
                new Car("jace", () -> true),
                new Car("mia", () -> false),
                new Car("noel", () -> false)
        );
        racingCars = new RacingCars(cars);
        racingCars.raceOfCars(cars);
    }

    @DisplayName("경주할 자동차 들의 초기화 상태 생성 테스트")
    @Test
    void initialCars() {
        final List<String> carNames = racingCars.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        racingCars = RacingCars.of(carNames);
        final List<Car> cars = racingCars.getCars();

        assertThat(cars.isEmpty()).isFalse();
        assertThat(cars).hasSize(3);
    }

    @DisplayName("자동차 최대 이동 거리 확인 테스트")
    @Test
    void checkMaxLocationByRacingCars() {
        final int maxLocation = getMaxLocationByRacingCars();
        assertThat(maxLocation).isEqualTo(racingCars.getMaxLocation());
    }

    @DisplayName("자동차 경주 우승자 확인 테스트")
    @Test
    void getCarNameByRacingWinner() {
        assertThat(racingCars.getWinners()).containsExactly("jace");
    }

    private int getMaxLocationByRacingCars() {
        return racingCars.getCars().stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }
}
