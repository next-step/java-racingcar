package racingcar.view.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import racingcar.domain.Race;
import racingcar.domain.RacingCar;

public class GameResultTest {

    @Test
    public void addRaceResult() {
        GameResult gameResult = new GameResult();

        Race someRace = new Race();
        List<Race> races = gameResult.addRaceResult(someRace);

        assertThat(races.size()).isEqualTo(1);
        assertThat(races.get(0)).isEqualTo(someRace);
    }

    @Test
    public void endGame_우승자_한명() {
        GameResult gameResult = new GameResult();

        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("one", 1));
        cars.add(new RacingCar("two", 2));
        cars.add(new RacingCar("three", 3));

        gameResult.addRaceResult(new Race(cars));
        gameResult.endGame();

        List<String> winnerNames = gameResult.getWinnerNames();

        assertThat(winnerNames.get(0)).isEqualTo("three");
    }

    @Test
    public void endGame_우승자_두명이상() {
        GameResult gameResult = new GameResult();

        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("one", 3));
        cars.add(new RacingCar("two", 3));
        cars.add(new RacingCar("three", 3));

        gameResult.addRaceResult(new Race(cars));
        gameResult.endGame();

        List<String> winnerNames = gameResult.getWinnerNames();

        assertThat(winnerNames).contains("two", "three", "one");
    }
}