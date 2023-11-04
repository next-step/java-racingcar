package carracing;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.ui.InputView;

public class Racing {
    private final Cars cars;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public static void main(String[] args) {
        Racing racing = new Racing(new Cars());
        racing.start();
    }

    public void start() {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        createCar(carCount);
        go(tryCount);
    }
    private void go(int tryCount) {
        cars.move(tryCount);
    }

    public void createCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.addCar(new Car());
        }
    }

    public Cars getCars() {
        return cars;
    }
}
