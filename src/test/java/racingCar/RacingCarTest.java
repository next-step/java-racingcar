package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    @Test
    void 게임테스트(){
        StartGame startGame = new StartGame();
        Cars cars = new Cars(3);

        startGame.racingCarGame(3,5, cars.carList);
    }

    @Test
    void 랜덤유효값(){
        StartGame startGame = new StartGame();
        for(int i=0; i<10; i++){
            int randomNumber = startGame.randomNumber();
            assertThat(randomNumber).isBetween(0,9);
        }
    }

    @Test
    void 움직이는경우(){
        StartGame startGame = new StartGame();
        Car car = new Car("-");

        startGame.moveCar(4, car);
        assertThat(car.getMove()).isEqualTo("--");

    }

    @Test
    void 안움직이는경우(){
        StartGame startGame = new StartGame();
        Car car = new Car("-");

        startGame.moveCar(3, car);
        assertThat(car.getMove()).isEqualTo("-");

    }
}
