package car.racing;

import java.util.ArrayList;
import java.util.List;

public class FakeResultView implements ResultViewContract {

    List<Car> cars = new ArrayList<>();
    String winners = "";

    @Override
    public void resultTitle() {

    }

    @Override
    public void newLine() {

    }

    @Override
    public void forward(List<Car> cars) {
        this.cars.clear();
        this.cars.addAll(cars);
    }

    @Override
    public void winners(String racingWinners) {
        winners = racingWinners;
    }
}
