package step33;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int amountOfCar = inputView.getAmountOfCar();
        int countOfCarRacing = inputView.getCountOfCarRacing();

        Car car = new Car(new ArrayList<>());
        CarRacing carRacing = new CarRacing(car, new RandomGenerator(new Random()));
        carRacing.createCars(amountOfCar);

        List<CarResponse> carResponses = carRacing.start(countOfCarRacing);
        ResultView resultView = new ResultView(carResponses);
        resultView.print();
    }
}
