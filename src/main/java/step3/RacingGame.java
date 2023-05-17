package step3;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        int numOfCar = InputView.getNumOfCar();
        int numOfTrial = InputView.getNumOfTrial();
        List <Car> cars = new ArrayList<>();

        for (int i = 0; i < numOfCar; i++) {
            cars.add(new Car());
        }

        Movement movement = new Movement(cars, new RandomMoveStrategy());
        ResultView.printResultMessage();

        for (int i = 0; i < numOfTrial; i++) {
            movement.moveCars();
            ResultView.printRaceResult(cars);
        }
    }
}
