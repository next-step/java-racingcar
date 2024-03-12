package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;
import racingcar.mock.AlwaysMoveStrategy;
import racingcar.mock.AlwaysStopStrategy;

import static org.assertj.core.api.Assertions.*;

public class WinnerTest {

    @Test
    @DisplayName("[성공] 자동차 경주의 최종 우승자가 한명인 경우 한명의 이름만 반환한다.")
    void 자동차_경주_우승자() {
        // Given
        Car moveCar = new Car(new Name("pobi"));
        Car stopCar1 = new Car(new Name("crong"));
        Car stopCar2 = new Car(new Name("honux"));

        moveCar.move(new AlwaysMoveStrategy());
        stopCar1.move(new AlwaysStopStrategy());
        stopCar2.move(new AlwaysStopStrategy());

        Cars cars = new Cars(moveCar, stopCar1, stopCar2);

        // When
        Winner winner = new Winner();
        Names winnerNames = winner.who(cars);

        assertThat(winnerNames.get()).containsExactlyInAnyOrder(new Name("pobi"));
    }

    @Test
    @DisplayName("[성공] 자동차 경주의 최종 우승자가 여러명인 경우 여러개의 이름을 반환한다.")
    void 자동차_경주_다수_우승자() {
        // Given
        Car moveCar1 = new Car(new Name("pobi"));
        Car moveCar2 = new Car(new Name("crong"));
        Car stopCar = new Car(new Name("honux"));

        moveCar1.move(new AlwaysMoveStrategy());
        moveCar2.move(new AlwaysMoveStrategy());
        stopCar.move(new AlwaysStopStrategy());

        Cars cars = new Cars(moveCar1, moveCar2, stopCar);

        // When
        Winner winner = new Winner();
        Names winnerNames = winner.who(cars);

        assertThat(winnerNames.get()).containsExactlyInAnyOrder(new Name("pobi"), new Name("crong"));
    }
}
