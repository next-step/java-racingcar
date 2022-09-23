import model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void shouldMoveCarByStrategy() {
        int carNumber = 3;
        RacingGame game = new RacingGame(() -> true, carNumber);
        Car car = new Car();
        int beforeGame = car.getCurrentPosition();
        game.moveCarByStrategy(car);
        int afterGame = car.getCurrentPosition();
        Assertions.assertThat(beforeGame).isLessThan(afterGame);
    }

    @Test
    void shouldNotMoveCarByStrategy() {
        int carNumber = 3;
        RacingGame game = new RacingGame(() -> false, carNumber);
        Car car = new Car();
        int beforeGame = car.getCurrentPosition();
        game.moveCarByStrategy(car);
        int afterGame = car.getCurrentPosition();
        Assertions.assertThat(afterGame).isEqualTo(beforeGame);
    }

    @Test
    void shouldReturnProperGameResult_whenCarStopped() {
        int carNumber = 1;
        RacingGame game = new RacingGame(() -> false, carNumber);
        Assertions.assertThat(game.play().getCarPositions()).containsExactly(0);
        Assertions.assertThat(game.play().getCarPositions()).containsExactly(0);
    }

    @Test
    void shouldReturnProperGameResult_whenCarMoved() {
        int carNumber = 1;
        RacingGame game = new RacingGame(() -> true, carNumber);
        Assertions.assertThat(game.play().getCarPositions()).containsExactly(1);
        Assertions.assertThat(game.play().getCarPositions()).containsExactly(2);
    }

}