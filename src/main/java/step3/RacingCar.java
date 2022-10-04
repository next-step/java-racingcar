package step3;

import static step3.ResultView.resultView;

import java.util.Random;
import test2.Positive;

public class RacingCar {

    private static final Random random = new Random();

    public RacingCar() {
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int carNumber = inputView.carNumber();
        int carRunningNumber = inputView.carRunningNumber();
        Car[] cars = carList(carNumber);
        resultView.startView();
        for(int i = 0; i < carRunningNumber; i++) {
            advanceCar(cars);
        }
    }

    private static Car[] carList(int carNumbers) {
        Car[] cars = new Car[carNumbers];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(0);
        }
        return cars;
    }

    private static void advanceCar(Car[] cars) {

        for(int i = 0; i < cars.length; i ++) {
            int carLocation = cars[i].advanceCar(random.nextInt(10));
            resultView(carLocation);
        }
        System.out.println("\n");
    }


}
