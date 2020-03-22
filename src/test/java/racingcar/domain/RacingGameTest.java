package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        List<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("crong");
        carNames.add("honux");
        carNames.add("seul");

        List<Car> cars = Car.listOf(carNames);
        cars.get(0).move(1);
        cars.get(1).move(2);
        cars.get(2).move(3);
        cars.get(3).move(3);

        GameRole gameRole = new GameRole(1);
        this.racingGame = new RacingGame(5, cars, gameRole);
    }

    @Test
    void start() {
        racingGame.start();
    }

    @Test
    void findWinner() {
        List<Car> winners = racingGame.findWinner();
        List<String> winnerNames = winners.stream().map(car -> car.getName())
                .collect(Collectors.toList());

        assertThat(winners).hasSize(2);
        assertThat(winnerNames).contains("honux", "seul");
    }
}
