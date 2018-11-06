package racing;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    private List<Car> cars;
    private GameResult gameResult;

    @Before
    public void setUp() throws Exception {
        Car carA = new Car("A", 3);
        Car carB = new Car("B", 7);
        Car carC = new Car("C", 7);

        cars = Arrays.asList(carA, carB, carC);

        gameResult = new GameResult(cars);
    }

    @Test
    public void setResult() {
        assertThat(gameResult.getCars().size()).isEqualTo(3);
    }

    @Test
    public void getWinner() {
        String result = gameResult.getWinner();
        assertThat(result).isEqualTo("B, C");
    }
}