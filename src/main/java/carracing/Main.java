package carracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Output.showInputCarName();
        String carName = Input.insertCarName();
        List<String> CarNames = Arrays.asList(carName.split(","));
        List<Car> cars = new ArrayList<>();
        for (String separateCarName : CarNames) {
            cars.add(new Car(separateCarName));
        }

        CarRacing carRacing = new CarRacing(cars);

        Output.showInputRacingCount();
        int gameCount = Input.insertGameCount();
        carRacing.moveCars(gameCount);
        Output.showCarsStatus(cars, gameCount);
        Output.showWinner(carRacing);
    }
}
