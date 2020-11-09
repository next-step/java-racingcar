package car.racing;

import car.racing.domain.Car;
import car.racing.view.ResultViewContract;

import java.util.ArrayList;
import java.util.List;

public class FakeResultView implements ResultViewContract {

    List<Car> cars = new ArrayList<>();

    @Override
    public void resultTitle() {

    }

    @Override
    public void newLine() {

    }

    @Override
    public void winners(List<String> racingWinners) {
    }

    @Override
    public void forward(Car car) {
        cars.add(car);
    }
}
