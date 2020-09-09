package step3;

import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.operation.Operation;
import step3.utils.CarFactory;
import step3.utils.FindWinners;
import step3.view.InputView;
import java.util.ArrayList;
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
