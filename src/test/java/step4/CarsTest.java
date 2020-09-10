package step4;

import org.junit.jupiter.api.Test;
import step4.controller.Operation;
import step4.domain.Car;
import step4.utils.CarFactory;
import step4.utils.FindWinners;
import step4.view.InputView;

import java.util.List;

public class CarsTest {

    @Test
    void findWinner() {

        String inputNames = "min,fin,jake";
        int count = 5;

        List<Car> cars = CarFactory.create(inputNames);
        InputView.inputTest(inputNames, count);

        for(int i = 0; i < count; i++) {
            Operation.progressByName(cars);
        }
        FindWinners.findWinners(cars, count);
    }
}
