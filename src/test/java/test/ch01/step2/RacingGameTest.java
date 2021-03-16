package test.ch01.step2;

import ch01.step2.Car;
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

        racingGame = new RacingGame();

        cars = new Car[3];
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        car1.setProgressBar("-");
        car2.setProgressBar("-");
        car3.setProgressBar("-");

        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;

        int attemptCount = 5;
        int carCount = 3;
    }


    @Test
    @DisplayName("차를 이동하는 Test")
    void moveCarTest() {

        //given
        int index = 2;
        String[] beforeArr = new String[3];

        //when
        racingGame.moveCar(cars, index, true);

        for (int i = 0; i < cars.length; i++) {
            beforeArr[i] = cars[i].getProgressBar();
        }
        String[] expectArr = {"-", "-", "--"};
        //then
        assertThat(beforeArr).isEqualTo(expectArr);
    }

    @ParameterizedTest
    @DisplayName("숫자 입력받아서 전진할것인지 결정하는 method")
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    void isKeepGoingTest(int inputNum, boolean expect) {
        racingGame.isKeepGoing(inputNum);
        assertThat(racingGame.isKeepGoing(inputNum)).isEqualTo(expect);
    }
}