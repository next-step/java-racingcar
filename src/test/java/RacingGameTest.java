import model.Car;
import model.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    void shouldMoveCarByStrategy() {
        String carName = "testCar";
        RacingGame game = new RacingGame(() -> true, (candidates) -> candidates, new String[]{carName});
        Car car = Car.carWithName(carName);
        int beforeGame = car.getCurrentPosition();
        game.moveCarByStrategy(car);
        int afterGame = car.getCurrentPosition();
        assertThat(beforeGame).isLessThan(afterGame);
    }

    @Test
    void shouldNotMoveCarByStrategy() {
        String carName = "testCar";
        RacingGame game = new RacingGame(() -> false, (candidates) -> candidates, new String[]{carName});
        Car car = Car.carWithName(carName);
        int beforeGame = car.getCurrentPosition();
        game.moveCarByStrategy(car);
        int afterGame = car.getCurrentPosition();
        assertThat(afterGame).isEqualTo(beforeGame);
    }

    @Test
    void shouldReturnProperGameResult_whenCarStopped() {
        String carName = "testCar";
        RacingGame game = new RacingGame(() -> false, (candidates) -> candidates, new String[]{carName});
        assertThat(getFistCarPosition(game.play())).isEqualTo(0);
        assertThat(getFistCarPosition(game.play())).isEqualTo(0);
    }

    @Test
    void shouldReturnProperGameResult_whenCarMoved() {
        String carName = "testCar";
        RacingGame game = new RacingGame(() -> true, (candidates) -> candidates, new String[]{carName});
        assertThat(getFistCarPosition(game.play())).isEqualTo(1);
        assertThat(getFistCarPosition(game.play())).isEqualTo(2);
    }

    private int getFistCarPosition(GameResult result) {
        return result.getCars().get(0).getCurrentPosition();
    }

}
