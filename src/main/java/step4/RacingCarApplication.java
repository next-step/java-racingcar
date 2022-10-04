package step4;

import step4.model.Car;
import step4.view.InputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.carName().split(",");
        int carNumber = inputView.carNumber();
        Car[] cars = newCar(carNames);
    }

    private static Car[] newCar(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for(int i = 0; i < carNames.length; i ++) {
            cars[i] = new Car(carNames[i], 0);
        }
        return cars;
    }
}
