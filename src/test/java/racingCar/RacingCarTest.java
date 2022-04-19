package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static java.lang.System.lineSeparator;
import static java.lang.System.setIn;
import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    @Test
    void 게임테스트(){
        String userInput = String.format("3%s5", lineSeparator(), lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));
        RacingCarMain.main(null);
    }

    @Test
    void 움직이는경우(){
        StartGame startGame = new StartGame();
        Cars cars = new Cars(1);

        startGame.moveCar(4, cars.carList, 0);
        assertThat(cars.carList.get(0)).isEqualTo("--");

    }

    @Test
    void 안움직이는경우(){
        StartGame startGame = new StartGame();
        Cars cars = new Cars(1);
        startGame.moveCar(3, cars.carList, 0);

        assertThat(cars.carList.get(0)).isEqualTo("-");


    }


}
