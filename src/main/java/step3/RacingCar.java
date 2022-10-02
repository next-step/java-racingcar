package step3;

import test2.Positive;

public class RacingCar {

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
        ResultView resultView = new ResultView();
        for(Car car : cars) {
            car.advanceNumber();
            resultView.resultView(car);
        }
        System.out.println("\n");
    }


}
