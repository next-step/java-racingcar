import model.Car;
import model.CarName;
import model.CarPosition;
import model.GameResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void shouldMoveCarByStrategy() {
        CarName carName = new CarName("test");
        RacingGame game = new RacingGame(() -> true, (candidates) -> candidates, List.of(carName));
        Car car = Car.carWithName(carName);
        CarPosition beforeGame = car.getCarPosition();

        game.moveCarByStrategy(car);

        CarPosition afterGame = car.getCarPosition();
        assertThat(afterGame.compareTo(beforeGame)).isPositive();
    }

    @Test
    void shouldNotMoveCarByStrategy() {
        CarName carName = new CarName("test");
        RacingGame game = new RacingGame(() -> false, (candidates) -> candidates, List.of(carName));
        Car car = Car.carWithName(carName);
        CarPosition beforeGame = car.getCarPosition();

        game.moveCarByStrategy(car);

        CarPosition afterGame = car.getCarPosition();
        assertThat(afterGame.compareTo(beforeGame)).isZero();
    }

    @Test
    void shouldReturnProperGameResult_whenCarStopped() {
        CarName carName = new CarName("test");
        RacingGame game = new RacingGame(() -> false, (candidates) -> candidates, List.of(carName));
        CarPosition carPosition = new CarPosition(0);

        assertThat(getFistCarPosition(game.play())).isEqualTo(carPosition);
        assertThat(getFistCarPosition(game.play())).isEqualTo(carPosition);
    }

    @Test
    void shouldReturnProperGameResult_whenCarMoved() {
        CarName carName = new CarName("test");
        RacingGame game = new RacingGame(() -> true, (candidates) -> candidates, List.of(carName));

        assertThat(getFistCarPosition(game.play())).isEqualTo(new CarPosition(1));
        assertThat(getFistCarPosition(game.play())).isEqualTo(new CarPosition(2));
    }

    private CarPosition getFistCarPosition(GameResult result) {
        return result.getCars().get(0).getCarPosition();
    }

}
