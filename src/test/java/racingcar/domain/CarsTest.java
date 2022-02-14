package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.movable.MovableStrategy;

public class CarsTest {

    @DisplayName("자동차 A, B를 moveAll로 모두 이동 시켰을때, 자동차의 distance 는 1이다.")
    @Test
    void GivenMoveStrategy_WhenMoveAll_ThenCarDistanceOne() {
        Cars cars = Cars.fromString("A, B");

        MovableStrategy move = () -> true;

        CarMoveTurnHistory carMoveTurnHistory = cars.moveAll(move);

        assertThat(
            carMoveTurnHistory.getCarMoveTurnHistory()
                .stream()
                .map(x -> x.getDistance())
                .allMatch(x -> x == 1)
        )
            .isEqualTo(true);
    }

    @DisplayName("자동차 A, B를 moveAll에서 이동조건이 맞지 않아 이동하지 않았을 때, 자동차의 distance 는 0이다.")
    @Test
    void GivenStopStrategy_WhenMoveAll_ThenCarDistanceZero() {
        Cars cars = Cars.fromString("A, B");

        MovableStrategy stop = () -> false;

        CarMoveTurnHistory carMoveTurnHistory = cars.moveAll(stop);

        assertThat(
            carMoveTurnHistory.getCarMoveTurnHistory()
                .stream()
                .map(x -> x.getDistance())
                .allMatch(x -> x == 0)
        )
            .isEqualTo(true);
    }

    @DisplayName("자동차 A, B를 moveAll로 모두 이동 시켰을때, 자동차의 distance 는 1이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void GivenMoveStrategyAndTurn_WhenMoveAll_ThenCarDistanceEqualToTurn(int turn) {
        CarMoveTurnHistory carMoveTurnHistory = CarMoveTurnHistory.create();
        Cars cars = Cars.fromString("A, B");

        MovableStrategy move = () -> true;

        for (int i = 0; i < turn; i++) {
            carMoveTurnHistory = cars.moveAll(move);
        }

        assertThat(
            carMoveTurnHistory.getCarMoveTurnHistory()
                .stream()
                .map(x -> x.getDistance())
                .allMatch(x -> x == turn)
        )
            .isEqualTo(true);
    }

    @DisplayName("3칸 이동하는 A와 2칸 이동하는 B가 주어졌을 때, 우승자를 필터링하면 A가 필터된다.")
    @Test
    void testCarDistancePrintingValid() {
        List<Boolean> aMoves = Arrays.asList(true, false, true, false, true);
        List<Boolean> bMoves = Arrays.asList(false, false, true, false, true);

        Car a = new Car("A");
        Car b = new Car("B");

        carMove(a, aMoves);
        carMove(b, bMoves);

        Cars cars = Cars.fromCarList(Arrays.asList(a, b));

        assertThat(cars.filterWinners())
            .isEqualTo(Arrays.asList(a));
    }

    private void carMove(Car car, List<Boolean> moves) {
        for (boolean carMoved : moves) {
            car.run(() -> carMoved);
        }
    }
}
