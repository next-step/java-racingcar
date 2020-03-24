package fifth_refactoring;

import org.junit.jupiter.api.Test;
import fifth_refactoring.Car;
import fifth_refactoring.RacingGame;
import fifth_refactoring.ResultView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    private Car car;
    private RacingGame racingGame;
    private ResultView resultview = new ResultView();

    @Test
    void makeSignTest(){
        List<Car> carList = new ArrayList();
        Car car = new Car();
        car.move();
        car.move();
        assertThat(resultview.makeSign(car.getCarPosition())).isEqualTo("---");
    }
}
