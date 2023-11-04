package carracing;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.ui.InputView;

public class Racing {
    public static void main(String[] args) {
        Racing racing = new Racing();
        racing.start();
    }

    public void start() {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        createCar(carCount);
    }
    public int createCar(int carCount) {
        Cars cars = new Cars();
        for (int i = 0; i < carCount; i++) {
            cars.addCar(new Car());
        }

        return cars.getCarListSize();
    }

}
