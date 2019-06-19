package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    List<Car> cars = new ArrayList<>();
    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        this.cars.add(Car.of("henrry"));
        this.cars.add(Car.of("helloworld"));
        this.cars.add(Car.of("hithere"));
        this.racingGame = RacingGame.of(cars);

    }

    @Test
    void getCars() {
        List<Car> racingGameCars = racingGame.getCars();
        assertThat(racingGameCars.get(0).getName()).isEqualTo("henrry");
        assertThat(racingGameCars.get(1).getName()).isEqualTo("helloworld");
        assertThat(racingGameCars.get(2).getName()).isEqualTo("hithere");
    }
}
