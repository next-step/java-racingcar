package carracing;

import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView();
//        List<Car> raceCars = participate(inputView.getAmount());

        ResultView resultView = new ResultView();
        for (int i = 0; i < inputView.getTrack(); i++) {
            List<Car> cars = new ArrayList<>();
            for (Car car : cars) {
                String print = resultView.print(car);
                System.out.println(print);
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
