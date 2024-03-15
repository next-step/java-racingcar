package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Winners;
import racing.domain.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private final MoveStrategy alwaysMoveStrategy = () -> true;
    private final Car carA = Car.from("testA");
    private final Car carB = Car.from("testB");

    @Test
    void constructor() {
        Cars cars = getCars(carA, carB);

        assertThat(cars).hasSize(2);
    }

    @Test
    @DisplayName("우승자가 한 명인 경우 우승자 목록 조회")
    void getWinners_one_winner() {
        // given
        carA.play(alwaysMoveStrategy);

        // when
        Winners winners = Winners.from(getCars(carA, carB));

        // then
        assertThat(winners).containsExactly(carA);
    }

    @Test
    @DisplayName("우승자가 여러 명인 경우 우승자 목록 조회")
    void getWinners_over_one_winner() {
        // given
        carA.play(alwaysMoveStrategy);
        carB.play(alwaysMoveStrategy);

        // when
        Winners winners = Winners.from(getCars(carA, carB));

        // then
        assertThat(winners).containsExactly(carA, carB);
    }

    private Cars getCars(Car... cars) {
        return Cars.from(List.of(cars));
    }

}