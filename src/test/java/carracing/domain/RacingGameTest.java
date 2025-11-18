package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    @DisplayName("우승자는 kim이다")
    void findWinner() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("kim", 3));
        cars.add(new RacingCar("lee", 2));
        cars.add(new RacingCar("park", 1));
        RacingGame racingGame = new RacingGame(cars);
        List<String> carNames = racingGame.findWinners();
        assertThat(carNames.getFirst()).isEqualTo("kim");
    }

    @Test
    @DisplayName("우승자는 여러명일 수 있다")
    void findWinners() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("kim", 3));
        cars.add(new RacingCar("lee", 3));
        cars.add(new RacingCar("park", 1));
        RacingGame racingGame = new RacingGame(cars);
        assertThat(racingGame.findWinners()).hasSize(2);
    }

    @Test
    @DisplayName("게임결과")
    void play() {
        RacingGame racingGame = new RacingGame("kim,lee", 3);
        racingGame.play();
        assertThat("kim,lee").contains(racingGame.findWinners());
    }
}