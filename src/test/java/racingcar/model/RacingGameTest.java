package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("입력한 자동차 대수만큼 자동차 객체를 생성하고 초기 위치는 0이다.")
    void createCarsTest() {
        List<String> carNames = List.of("car1", "car2", "car3");

        RacingGame racingGame = RacingGame.createRacingGame(carNames);

        assertThat(racingGame.hasCarCount(carNames.size())).isTrue();
        assertThat(racingGame.areAllCarsAtPosition(new Position(0))).isTrue();
    }

    @Test
    @DisplayName("우승자를 정확히 추출할 수 있다")
    void get_winner_cars() {

        Car win = new Car(new CarName("win"), new Position(3));
        Car lose = new Car(new CarName("lose"), new Position(1));

        RacingGame game = RacingGame.ofCars(List.of(win, lose));

        List<Car> winners = game.getWinners();

        assertThat(winners).containsExactly(win);
    }

    @Test
    @DisplayName("최대 위치를 정확히 찾는다")
    void find_max_position_test() {
        Car a = new Car(new CarName("a"), new Position(2));
        Car b = new Car(new CarName("b"), new Position(5));
        Car c = new Car(new CarName("c"), new Position(1));

        RacingGame game = RacingGame.ofCars(List.of(a, b, c));

        List<Car> winners = game.getWinners();

        assertThat(winners).containsExactly(b);
    }
}
