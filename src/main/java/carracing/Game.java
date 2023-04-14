package carracing;

import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Car> raceCars = participate(inputView.getAmount());

        for (int i = 0; i < inputView.getTrack(); i++) {
            race(raceCars);
            System.out.println();
        }
    }

    private static int randomSpeed() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private static List<Car> participate(int amount) {
        List<Car> raceCars = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Car car = new Car();
            raceCars.add(car);
        }

        return raceCars;
    }

    private static void race(List<Car> raceCars) {
        ResultView resultView = new ResultView();

        for (Car car : raceCars) {
            resultView.print(car.move(randomSpeed()));
        }
    }
}
