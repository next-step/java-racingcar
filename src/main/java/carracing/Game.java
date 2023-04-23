package carracing;

import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static InputView inputView;
    private static ResultView resultView;

    public static void main(String[] args) {
        inputView = new InputView();
        List<Car> raceCars = participate(inputView.getNames());

        for (int i = 0; i < inputView.getTrack(); i++) {
            race(raceCars);
        }
        List<Car> winners = Winner.findWinner(raceCars);
        for (Car car : winners) {
            System.out.println(car.getName());
        }

    }

    public static List<Car> participate(List<String> carNameList) {
        List<Car> raceCars = new ArrayList<>();
        for (String name : carNameList) {
            raceCars.add(new Car(name));
        }
        return raceCars;
    }

    private static int randomSpeed() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static void race(List<Car> raceCars) {
        resultView = new ResultView();
        for (Car car : raceCars) {
            car.move(randomSpeed());
            System.out.println(resultView.print(car));
        }
        System.out.println();
    }


}
