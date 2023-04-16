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
            ResultView resultView = new ResultView();
            List<Integer> steps = race(raceCars);
            for (Integer step : steps) {
                resultView.print(step);
            }
            System.out.println();
        }
    }

    private static int randomSpeed() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static List<Car> participate(int amount) {
        List<Car> raceCars = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Car car = new Car();
            raceCars.add(car);
        }

        return raceCars;
    }

    public static List<Integer> race(List<Car> raceCars) {
        List<Integer> steps = new ArrayList<>();
        for (Car car : raceCars) {
           steps.add(car.move(randomSpeed()));
        }
        return steps;
    }
}
