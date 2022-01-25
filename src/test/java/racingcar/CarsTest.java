package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.RandomMovableStrategy;

public class CarsTest {

    private static final int TURNS = 10;
    private Cars cars;

    @BeforeEach
    void setUp() {
        Car A = new Car("A");
        Car B = new Car("B");
        Car C = new Car("C");
        Car D = new Car("D");
        cars = new Cars(Arrays.asList(A, B, C, D));

        for (int i = 0; i < TURNS; i++) {
            cars.moveAll(RandomMovableStrategy.getInstance());
        }
    }

    @DisplayName("플레이어가 존재하지 않으면 IllegalArgumentException 발생")
    @Test
    void testCarsAreEmpty() {
        assertThatThrownBy(() -> new Cars(Collections.emptyList()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소한 1명 이상의 우승자 존재 여부 확인")
    @Test
    void testWinnerExists() {
        assertTrue(cars.filterWinners().size() >= 1);
    }

    @DisplayName("시나리오 상으로 의도한 플레이어가 우승하였는지 검증")
    @Test
    void testWinnerValid() {
        // Given
        Car a = new Car("A");
        Car b = new Car("B");

        List<Boolean> aMoves = Arrays.asList(true, false, true, false, true);
        List<Boolean> bMoves = Arrays.asList(false, false, true, false, true);

        carMove(a, aMoves);
        carMove(b, bMoves);

        Cars cars = new Cars(Arrays.asList(a, b));

        // Then
        assertThat(cars.filterWinners())
            .isEqualTo(Collections.singletonList(a));
    }

    @DisplayName("자동차가 움직였는지 검사, 모든 하나의 자동차는 최소 1 이상의 거리는 움직였음을 테스트")
    @Test
    void testCarsRun() {
        List<Integer> distancesByCar = cars.get().stream()
            .map(Car::distance)
            .collect(Collectors.toList());

        assertThat(distancesByCar).asList()
            .filteredOn(dist -> (Integer) dist > 0)
            .isNotEmpty();
    }

    // 자동차 이동 로직
    void carMove(Car car, List<Boolean> moves) {
        for (boolean carMoved: moves) {
            car.run(() -> carMoved);
        }
    }
}
