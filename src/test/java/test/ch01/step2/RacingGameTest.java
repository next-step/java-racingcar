package test.ch01.step2;


import ch01.racinggame.domain.Car;
import ch01.racinggame.domain.InputData;
import ch01.racinggame.domain.RacingGame;
import ch01.racinggame.domain.RandomNumber;
import ch01.racinggame.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;
    private RandomNumber randomNumber;
    private final String inputNameOfCars = "happy,game,dog,cat,home";
    ResultView rv;

    @BeforeEach
    void setUp() {
        int attemptCount = 3;

        randomNumber = new RandomNumber();

        InputData inputData = new InputData(inputNameOfCars, attemptCount);


        racingGame = new RacingGame(inputData);
        //racingGame.start();

    }

    @Test
    @DisplayName("game start Test")
    void startTest() {
        racingGame.start();
        rv = new ResultView(racingGame.cars());
        Car[] testCars = new Car[racingGame.cars().length];


        assertThat(racingGame.cars().length).isEqualTo(5);
    }

}