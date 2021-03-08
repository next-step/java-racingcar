package step3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int amountOfCar = inputView.getAmountOfCar();
        int countOfCar = inputView.getCountOfCar();

        CarRacing carRacing = new CarRacing(new ArrayList<>());
        carRacing.createCars(amountOfCar);
        carRacing.moveCars(countOfCar);
    }
}
