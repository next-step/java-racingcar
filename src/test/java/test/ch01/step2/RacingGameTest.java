package test.ch01.step2;


import ch01.racinggame.Domain.Car;
import ch01.racinggame.Domain.InputData;
import ch01.racinggame.Domain.RacingGame;
import ch01.racinggame.Domain.RandomNumber;
import ch01.racinggame.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    RacingGame racingGame;
    Car[] cars;
    RandomNumber randomNumber;
    final int attemptCount = 3;
    final String inputNameOfCars = "happy,game,dog,cat,home";

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
    void startTest(){
        racingGame.start();
        ResultView rv = new ResultView();
        rv.showResult();

    }



    @Test
    @DisplayName("차를 이동하는 Test")
    void moveCarTest() {

        //given
        int index = 2;

        int testRandomNum = 5;
        //when
        racingGame.moveCar(cars, index, testRandomNum);

        //then
        assertThat(cars[index].toString()).isEqualTo("--");
    }

    @ParameterizedTest
    @DisplayName("숫자 입력받아서 전진할것인지 결정하는 method")
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    void isKeepGoingTest(int inputNum, boolean expect) {
        racingGame.isKeepGoing(inputNum);
        assertThat(racingGame.isKeepGoing(inputNum)).isEqualTo(expect);

    }
}