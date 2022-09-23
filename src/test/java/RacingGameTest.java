import model.Car;
import model.GameResult;
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
    void shouldNotMoveCarByStrategy(){
        int carNumber = 3;
        RacingGame game = new RacingGame(()->false, carNumber);
        Car car = new Car();
        String beforeGame = car.getCurrentPosition();
        game.moveCarByStrategy(car);
        String afterGame = car.getCurrentPosition();
        Assertions.assertThat(afterGame.length()).isEqualTo(beforeGame.length());
    }

    @Test
    void shouldReturnProperGameResult_whenCarStopped(){
        int carNumber = 1;
        RacingGame game = new RacingGame(()->false, carNumber);
        GameResult resultA = game.play();
        GameResult resultB = game.play();
        Assertions.assertThat(resultA.getResult()).isEqualTo(Car.POSITION_UNIT+"\n");
        Assertions.assertThat(resultB.getResult()).isEqualTo(Car.POSITION_UNIT+"\n");
    }

    @Test
    void shouldReturnProperGameResult_whenCarMoved(){
        int carNumber = 1;
        RacingGame game = new RacingGame(()->true, carNumber);
        GameResult resultA = game.play();
        GameResult resultB = game.play();
        Assertions.assertThat(resultA.getResult()).isEqualTo(Car.POSITION_UNIT+"\n");
        Assertions.assertThat(resultB.getResult()).isEqualTo(Car.POSITION_UNIT+Car.POSITION_UNIT+"\n");
    }

}