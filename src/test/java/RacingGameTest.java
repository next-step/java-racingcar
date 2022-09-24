import model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void shouldMoveCarByStrategy() {
        String carName = "testCar";
        RacingGame game = new RacingGame(() -> true ,(candidates) -> candidates, new String[]{carName});
        Car car = Car.carWithName(carName);
        int beforeGame = car.getCurrentPosition();
        game.moveCarByStrategy(car);
        int afterGame = car.getCurrentPosition();
        Assertions.assertThat(beforeGame).isLessThan(afterGame);
    }

    @Test
    void shouldNotMoveCarByStrategy() {
        String carName = "testCar";
        RacingGame game = new RacingGame(() -> false ,(candidates) -> candidates, new String[]{carName});
        Car car = Car.carWithName(carName);
        int beforeGame = car.getCurrentPosition();
        game.moveCarByStrategy(car);
        int afterGame = car.getCurrentPosition();
        Assertions.assertThat(afterGame).isEqualTo(beforeGame);
    }

    @Test
    void shouldReturnProperGameResult_whenCarStopped() {
        String carName = "testCar";
        RacingGame game = new RacingGame(() -> false ,(candidates) -> candidates, new String[]{carName});
        Assertions.assertThat(getFistCarPosition(game)).isEqualTo(0);
        Assertions.assertThat(getFistCarPosition(game)).isEqualTo(0);
    }

    @Test
    void shouldReturnProperGameResult_whenCarMoved() {
        String carName = "testCar";
        RacingGame game = new RacingGame(() -> true ,(candidates) -> candidates, new String[]{carName});
        Assertions.assertThat(getFistCarPosition(game)).isEqualTo(1);
        Assertions.assertThat(getFistCarPosition(game)).isEqualTo(2);
    }

    private int getFistCarPosition(RacingGame game) {
        return game.play().getCars().get(0).getCurrentPosition();
    }

}
