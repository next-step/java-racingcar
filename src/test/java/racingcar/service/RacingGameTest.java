package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Position;
import racingcar.repository.RacingCarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("참여한 자동차 수 확인")
    @Test
    void join() {
        Cars cars = new Cars(List.of(new Car("a"), new Car("b"), new Car("c")));

        RacingGame game = new RacingGame(new RacingCarRepository());
        game.join(cars);

        assertThat(game.joinCount()).isEqualTo(3);
    }

    @DisplayName("모두 출발하는 경우")
    @Test
    void race() {
        RacingRequest request = new RacingRequest("noose,pobi", 2);
        RacingGame game = new RacingGame(new RacingCarRepository(), () -> false);

        game.start(request);

        List<Car> movedCars = game.getCars();
        assertThat(movedCars.get(0).position()).isEqualTo(new Position(3));
        assertThat(movedCars.get(1).position()).isEqualTo(new Position(3));
    }

    @DisplayName("모두 출발하지 못한 경우")
    @Test
    void raceNoMove() {
        RacingRequest request = new RacingRequest("noose,pobi", 2);
        RacingGame game = new RacingGame(new RacingCarRepository(), () -> false);

        game.start(request);

        List<Car> movedCars = game.getCars();
        assertThat(movedCars.get(0).position()).isEqualTo(new Position());
        assertThat(movedCars.get(1).position()).isEqualTo(new Position());
    }
}
