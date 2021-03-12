package step4;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String drivers = InputView.getDrivers();
        int countOfCarRacing = InputView.getCountOfCarRacing();

        CarRacing carRacing = new CarRacing(drivers.split(","));

        ResultView.printStart();
        List<Car> ready = carRacing.getCurrentStatus();
        ResultView.printCarsMove(ready);

        for (int i=0; i<countOfCarRacing; i++) {
            carRacing.start(new Random());
            List<Car> currentStatus = carRacing.getCurrentStatus();
            ResultView.printCarsMove(currentStatus);
        }
        ResultView.printWinner(carRacing.getWinner());
    }
}
