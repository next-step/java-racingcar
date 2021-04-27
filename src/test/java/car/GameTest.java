package car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobiwonijuni"})
    public void getCar(String carInput) {
        Game game = new Game();
        Car car = game.getCar(carInput);
        System.out.println(car.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiwonijuni"})
    public void carNameinput2(String carInput) {
        Game game = new Game();
        game.getCar(carInput);
    }
}
