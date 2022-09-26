package view;

import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResultViewTest {
    @Test
    void 실행결과_확인() {
        List<Car> cars = InputView.makeCar(3);
        ResultView.printResult();
        ResultView.printPlayResult(cars);
    }
}