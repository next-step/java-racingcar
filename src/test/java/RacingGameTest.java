import model.Car;
import model.CarName;
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
        int beforeGame = car.getCurrentPosition();

        game.moveCarByStrategy(car);

        int afterGame = car.getCurrentPosition();
        assertThat(beforeGame).isLessThan(afterGame);
    }

    @Test
    void shouldNotMoveCarByStrategy() {
        CarName carName = new CarName("test");
        RacingGame game = new RacingGame(() -> false, (candidates) -> candidates, List.of(carName));
        Car car = Car.carWithName(carName);
        int beforeGame = car.getCurrentPosition();

        game.moveCarByStrategy(car);

        int afterGame = car.getCurrentPosition();
        assertThat(afterGame).isEqualTo(beforeGame);
    }

    @Test
    void shouldReturnProperGameResult_whenCarStopped() {
        CarName carName = new CarName("test");
        RacingGame game = new RacingGame(() -> false, (candidates) -> candidates, List.of(carName));

        assertThat(getFistCarPosition(game.play())).isEqualTo(0);
        assertThat(getFistCarPosition(game.play())).isEqualTo(0);
    }

    @Test
    void shouldReturnProperGameResult_whenCarMoved() {
        CarName carName = new CarName("test");
        RacingGame game = new RacingGame(() -> true, (candidates) -> candidates, List.of(carName));

        assertThat(getFistCarPosition(game.play())).isEqualTo(1);
        assertThat(getFistCarPosition(game.play())).isEqualTo(2);
    }

    private int getFistCarPosition(GameResult result) {
        return result.getCars().get(0).getCurrentPosition();
    }

}
