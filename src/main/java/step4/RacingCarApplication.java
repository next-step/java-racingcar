package step4;

import java.util.Random;
import step4.model.Car;
import step4.view.InputView;

public class RacingCarApplication {

    private static Random random = new Random();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.carName().split(",");
        int carNumber = inputView.carNumber();
        Car[] cars = newCar(carNames);
        for (int i = 0; i < carNumber; i ++) {
            int location = advance(cars);
        }
    }

    private static Car[] newCar(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for(int i = 0; i < carNames.length; i ++) {
            cars[i] = new Car(carNames[i], 0);
        }
        return cars;
    }

    private static int advance(Car[] cars) {
        for (Car car : cars) {
            return car.advanceCar(random.nextInt(9));
        }
        return 0;
    }

}
