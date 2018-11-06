package racing;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    private GameResult gameResult;

    @Before
    public void setUp() throws Exception {
        gameResult = new GameResult();
    }

    @Test
    public void setResult() {
        GameResult gameResult = new GameResult();
        Car car = new Car("A");
        gameResult.setResult(car);

        assertThat(gameResult.getCars().size()).isEqualTo(1);
    }

    @Test
    public void getWinner() {
        Car carA = new Car("A");
        carA.addPosition(3);
        Car carB = new Car("B");
        carB.addPosition(7);
        Car carC = new Car("C");
        carC.addPosition(5);


        gameResult.setResult(carA);
        gameResult.setResult(carB);
        gameResult.setResult(carC);
        String result = gameResult.getWinner();
        assertThat(result).isEqualTo("B, C가 최종 우승했습니다.");
    }
}