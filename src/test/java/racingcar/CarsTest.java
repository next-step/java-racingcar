package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.MovableStrategy;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.utils.Parser;

public class CarsTest {

    @DisplayName("3칸 이동하는 A와 2칸 이동하는 B가 주어졌을 때, 우승자를 필터링하면 A가 필터된다.")
    @Test
    void testCarDistancePrintingValid() {
        List<Boolean> aMoves = Arrays.asList(true, false, true, false, true);
        List<Boolean> bMoves = Arrays.asList(false, false, true, false, true);

        Car a = new Car("A");
        Car b = new Car("B");

        carMove(a, aMoves);
        carMove(b, bMoves);

        Cars cars = new Cars(Arrays.asList(a, b));

        assertThat(cars.filterWinners())
            .isEqualTo(Arrays.asList(a));
    }

    private void carMove(Car car, List<Boolean> moves) {
        for (boolean carMoved: moves) {
            car.run(() -> carMoved);
        }
    }
}
