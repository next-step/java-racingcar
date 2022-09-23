import model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void shouldMoveCarByStrategy(){
        int carNumber = 3;
        RacingGame game = new RacingGame(()->true, carNumber);
        Car car = new Car();
        String beforeGame = car.getCurrentPosition();
        game.moveCarByStrategy(car);
        String afterGame = car.getCurrentPosition();
        Assertions.assertThat(beforeGame.length()).isLessThan(afterGame.length());
    }

    @Test
    void shouldNotMoveCar(){
        int carNumber = 3;
        RacingGame game = new RacingGame(()->false, carNumber);
        Car car = new Car();
        String beforeGame = car.getCurrentPosition();
        game.moveCarByStrategy(car);
        String afterGame = car.getCurrentPosition();
        Assertions.assertThat(afterGame.length()).isEqualTo(beforeGame.length());
    }

}