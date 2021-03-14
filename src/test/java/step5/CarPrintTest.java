package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.View.OutputView;
import step5.domain.Car;
import step5.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarPrintTest {

    @DisplayName("포지션에 따라 -가 잘나오는지 테스트")
    @Test
    void printCarTest() {
        OutputView outputView = new OutputView();
        Car car = new Car("abc", 1);
        Car car1 = new Car("aaa", 2);
        List<Car> list = new ArrayList<>();
        list.add(car);
        list.add(car1);
        Cars cars = new Cars(list);
        outputView.printCarMove(cars);
    }

}
