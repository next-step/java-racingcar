package study;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {

    @DisplayName("자동차들 중에서 가장 멀리 간 위치가 어디인지 알 수 있다.")
    @Test
    void maxDistance() {
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car("aa", 1));
        cars.add(new Car("aa", 3));
        RacingGame.showWinner(cars);
        AssertionsForClassTypes.assertThat(cars.get(0).getPosition()).isEqualTo(3);
    }

    @DisplayName("자동차들 중 가장 멀리간 차를 위너로 뽑을 수 있다.")
    @Test
    void winner() {
        final List<Car> cars = new ArrayList<>();
        List<String> winnerCars = new ArrayList<>();
        cars.add(new Car("aa", 10));
        cars.add(new Car("bb", 6));
        cars.add(new Car("cc", 3));
        RacingGame.showWinner(cars);
        winnerCars = RacingGame.getWinnerList(cars);

        AssertionsForClassTypes.assertThat(winnerCars.get(0)).isEqualTo(cars.get(0).getName());
    }


}
