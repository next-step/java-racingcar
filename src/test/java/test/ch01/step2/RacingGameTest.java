package test.ch01.step2;

import ch01.step2.Car;
import ch01.step2.InputData;
import ch01.step2.InputView;
import ch01.step2.RacingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    RacingGame racingGame;
    Car[] cars;

    @BeforeEach
    void setUp() {
        int attemptCount = 5;
        int carCount = 3;

        InputView iv = new InputView();
        InputData inputData = new InputData(carCount,attemptCount);
        racingGame = new RacingGame(inputData);

        cars = new Car[3];
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;

    }


    @Test
    @DisplayName("차를 이동하는 Test")
    void moveCarTest() {

        //given
        int index = 2;

        //when
        racingGame.moveCar(cars, index, true);


        //then
        assertThat(cars[index].toString()).isEqualTo("-");
    }

    @ParameterizedTest
    @DisplayName("숫자 입력받아서 전진할것인지 결정하는 method")
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    void isKeepGoingTest(int inputNum, boolean expect) {
        racingGame.isKeepGoing(inputNum);
        assertThat(racingGame.isKeepGoing(inputNum)).isEqualTo(expect);
    }
}