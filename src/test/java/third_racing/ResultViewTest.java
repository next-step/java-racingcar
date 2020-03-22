package third_racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    private Car car;
    private RacingGame racingGame;
    private Resultview resultview;

    @Test
    void makeSignTest(){
        List<Car> carList = new ArrayList();
        Car car = new Car();
        car.move();
        car.move();
        assertThat(resultview.makeSign(car.getCarPosition())).isEqualTo("---");
    }
}
