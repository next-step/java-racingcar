package carracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        List<Car> cars = new ArrayList<>();

        output.showInputCarName();
        String carName = input.insertCarName();
        List<String> separateCarNames = Arrays.asList(carName.split(","));
        for (String separateCarName : separateCarNames) {
            cars.add(new Car(separateCarName));
        }

        CarRacing carRacing = new CarRacing(cars);

        output.showInputRacingCount();
        int gameCount = input.insertGameCount();
        output.showCarStatus(cars, gameCount);
        output.showWinner(carRacing);
    }
}
