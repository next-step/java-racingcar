package car.racing;

import java.util.ArrayList;
import java.util.List;

public class FakeResultView implements CarRacingContract.View {

    List<Car> cars = new ArrayList<>();

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
}
