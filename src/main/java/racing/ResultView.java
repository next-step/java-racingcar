package racing;

import java.util.List;

public class ResultView extends View<Void, List<Car>> {
    @Override
    public Void show(List<Car> cars) {
        for (Car car : cars) {
            showCar(car);
        }

        return null;
    }

    private void showCar(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
