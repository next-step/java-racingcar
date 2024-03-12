package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private final MoveStrategy alwaysMoveStrategy = () -> true;
    private final Car carA = new Car(new Name("testA"));
    private final Car carB = new Car(new Name("testB"));

    @Test
    void constructor() {
        Cars cars = getCars(carA, carB);

        assertThat(cars).hasSize(2);
    }

    @Test
    @DisplayName("우승자가 한 명인 경우 우승자 목록 조회")
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
    @DisplayName("우승자가 여러 명인 경우 우승자 목록 조회")
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