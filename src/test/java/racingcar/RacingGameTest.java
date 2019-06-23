package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.utils.NumGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private String carNames;
    private int times;
    private NumGenerator numGenerator;

    @BeforeEach
    void setUp(){
        carNames = "a, b";
        times = 1;
        numGenerator = new FixedNumGenerator(5);
    }

    @Test
    void testWinners(){
        RacingGame rg = new RacingGame(carNames, times, numGenerator);
        Cars cars = rg.run();
        assertThat(cars.getWinners()).containsExactly(new Car("a", 1, numGenerator),
                new Car("b", 1, numGenerator));

    }
}
