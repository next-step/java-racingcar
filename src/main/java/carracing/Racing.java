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
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = InputView.inputCarCount();

        System.out.println("시도할 회수는 몇 회 인가요?");
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
