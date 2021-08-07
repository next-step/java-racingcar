package edu.nextstep.racingcarwinner.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void joinGame(){
        // given
        String inputString = "hwan,hyun,kook";
        String[] carNameArr = inputString.split(",");
        RacingCars racingCars = RacingCars.of(carNameArr);

        // when
        RacingGame racingGame = new RacingGame();
        racingGame.joinGame(racingCars);

        // then
        assertThat(racingCars.getRacingCars()).contains(new Car("hwan"),
                new Car("hyun"),
                new Car("kook"));
    }

    @Test
    void playOneRound(){
        // given
        RacingCars racingCars = RacingCars.of(new String[]{"hwan", "hyun", "kook"});
        // when
        racingCars.move(() -> true);
        // then
        assertThat(racingCars.getRacingCars()).contains(new Car("hwan",1),
                new Car("hyun",1),
                new Car("kook",1));
    }

    @Test
    void getWinner(){
        // given
        RacingCars racingCars = RacingCars.of(Arrays.asList(new Car("hwan", 3),
                                                                    new Car("hyun", 2),
                                                                    new Car("kook", 3)));
        RacingGame racingGame = new RacingGame();
        racingGame.joinGame(racingCars);

        // when
        List<Car> winners = racingGame.getWinner();

        // then
        assertThat(winners).contains(new Car("hwan",3),
                new Car("kook",3));
    }
}
