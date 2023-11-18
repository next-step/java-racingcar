package carracing.domain.game;

import carracing.domain.car.Car;
import carracing.domain.car.CarName;
import carracing.domain.car.Cars;
import carracing.domain.car.Winners;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private CarName carName;
    private MovingStrategy randomRange;
    private WinnerStrategy maxMoving;

    @BeforeEach
    void setUp() {
        this.carName = new CarName("abc");
        this.randomRange = new RandomRange(1, 1);
        this.maxMoving = new MaxMoving();
    }

    @Test
    void winners_threeCars_fiveTriesWithMaxMoving_oneWinner() {
        Car car1 = new Car(5, carName);
        Car car2 = new Car(3, carName);
        Car car3 = new Car(1, carName);
        Cars racingCars = new Cars(List.of(car1, car2, car3));
        Cars winCars = new Cars(List.of(car1));

        RacingGame racingGame = new RacingGame(racingCars, 5);
        racingGame.race(randomRange);
        Winners winners = racingGame.winners(maxMoving);
        Winners expected = new Winners(winCars);

        assertThat(expected).isEqualTo(winners);
    }
}
