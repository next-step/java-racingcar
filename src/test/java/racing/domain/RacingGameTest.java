package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("자동차 게임을 진행하면 자동차가 위치가 이동된다")
    void move_postion() {
        Cars cars = Cars.create(new String[]{"pobi", "crong", "honux"});
        RacingGame racingGame = new RacingGame(cars, 5);
        racingGame.play();
        assertThat(cars.getCars().get(0).getPosition() > 1);
        assertThat(cars.getCars().get(1).getPosition() > 1);
    }

    @Test
    @DisplayName("우승자 이름을 알려줄 수 있다")
    void find_winner() {
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("crong", 5);
        Car car3 = new Car("honux", 2);
        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = Cars.create(carList);
        RacingGame racingGame = new RacingGame(cars, 5);
        Winners winner = racingGame.findWinner();
        assertThat(winner.getWinners().size()).isEqualTo(1);
        assertThat(winner.getWinners().get(0).getName()).isEqualTo("crong");
    }
}
