package fifth_refactoring;

import fifth_refactoring.domain.Car;
import org.junit.jupiter.api.Test;
import fifth_refactoring.view.ResultView;

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

    @Test
    void setRankTest() {
        List<Car> carList = new ArrayList<Car>();

        Car car1 = new Car();
        car1.setCarName("test1");
        carList.add(car1);

        Car car2 = new Car();
        car2.setCarName("test2");
        car2.move();
        carList.add(car2);

        assertThat(ResultView.setRank(carList)).isEqualTo("test2");
    }
}
