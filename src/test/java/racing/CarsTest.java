package racing;

import org.junit.jupiter.api.Test;
import racing.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private final MoveStrategy alwaysMoveStrategy = () -> true;
    private final Car carA = new Car("testA");
    private final Car carB = new Car("testB");

    @Test
    void constructor() {
        Cars cars = getCars(carA, carB);

        assertThat(cars).hasSize(2);
    }

    @Test
    void getWinnerList_one_winner() {
        // given
        Cars cars = getCars(carA, carB);
        carA.play(alwaysMoveStrategy);

        // when
        List<Car> winnerList = cars.getWinnerList();

        // then
        assertThat(winnerList).containsExactly(carA);
    }

    @Test
    void getWinnerList_over_one_winner() {
        // given
        carA.play(alwaysMoveStrategy);
        carB.play(alwaysMoveStrategy);

        Cars cars = getCars(carA, carB);

        // when
        List<Car> winnerList = cars.getWinnerList();

        // then
        assertThat(winnerList).containsExactly(carA, carB);
    }

    private Cars getCars(Car... cars) {
        return new Cars(List.of(cars));
    }

}