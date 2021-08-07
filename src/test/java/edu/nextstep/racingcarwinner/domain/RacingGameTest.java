package edu.nextstep.racingcarwinner.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void joinRacingGame(){
        // given
        String inputString = "hwan,hyun,kook";
        RacingGame racingGame = new RacingGame();
        List<Car> carList = racingGame.makeCarList(inputString);

        // when
        racingGame.joinGame(carList);

        // then
        assertThat(racingGame.getJoinedCarList()).contains(new Car("hwan"),
                new Car("hyun"),
                new Car("kook"));
    }

    @Test
    void getWinner(){
        // given
        RacingGame racingGame = new RacingGame();
        racingGame.joinGame(Arrays.asList(new Car("hwan", 3),
                new Car("hyun", 2),
                new Car("kook", 3)));

        // when
        List<Car> winners = racingGame.getWinner();

        // then
        System.out.println(winners);
        assertThat(winners).contains(new Car("hwan",3),
                new Car("kook",3));
    }
}
