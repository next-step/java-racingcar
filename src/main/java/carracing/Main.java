package carracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        List<Car> cars = new ArrayList<>();

        input.insertCarName();
        List<String> separateCarNames = Arrays.asList(input.getCarName().split(","));
        for (int i = 0; i < separateCarNames.size(); i++) {
            cars.add(new Car(separateCarNames.get(i)));
            new Car(separateCarNames.get(i)).nameCheck();
        }

        input.insertGameCount();

        output.showCarStatus(cars, input.getRaceCount());
        output.showWinner(cars);
    }
}
