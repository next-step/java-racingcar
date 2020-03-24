package fifth_refactoring.view;

import fifth_refactoring.domain.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    private Car car;
    private ResultView resultview = new ResultView();

    @Test
    void makeSignTest(){
        List<Car> carList = new ArrayList();
        Car car = new Car("test1");
        car.move();
        car.move();
        assertThat(resultview.makeSign(car.getCarPosition())).isEqualTo("---");
    }

    @Test
    void setRankTest() {
        List<Car> carList = new ArrayList<Car>();

        Car car1 = new Car("test1");
        carList.add(car1);

        Car car2 = new Car("test2");
        car2.move();
        carList.add(car2);

        assertThat(ResultView.setRank(carList)).isEqualTo("test2");
    }
}
