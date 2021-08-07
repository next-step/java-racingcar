package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ResultViewTest {

    @Test
    @DisplayName("printResult 테스트")
    void printResultTest() {
        //given
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        carList.add(car1);
        carList.add(car2);
        Cars cars = new Cars(carList);
        //then
        ResultView.printResult(cars);
    }

}