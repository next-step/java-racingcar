package car;

import java.util.*;

public class RacingCarGame {
    private static final String PRINT_FORMAT = "-";
    public static void main(String[] args) {
        int carCount = InputView.getInput(InputType.CAR_COUNT);
        int tryCount = InputView.getInput(InputType.TRY_COUNT);

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(i));
        }

        Movement movement = new Movement(cars,new RandomMoveStrategy());

        for (int i = 0; i < tryCount; i++) {
            movement.moveCars();
            ResultView.printRaceResult(cars,PRINT_FORMAT);
        }
    }
}
