package carracing;

import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final Random random = new Random();


    public static void main(String[] args) {
        List<Car> raceCars = participate(inputView.getNames());

        for (int i = 0; i < inputView.getTrack(); i++) {
            race(raceCars);
        }

        Winner winners = new Winner(raceCars);
        System.out.println(resultView.printWinner(winners.getWinners()));
    }

    public static List<Car> participate(List<String> carNameList) {
        List<Car> raceCars = new ArrayList<>();
        for (String name : carNameList) {
            raceCars.add(new Car(name));
        }
        return raceCars;
    }

    private static int randomSpeed() {
        return random.nextInt(10);
    }

    public static void race(List<Car> raceCars) {
        for (Car car : raceCars) {
            car.move(randomSpeed());
            System.out.println(resultView.print(car));
        }
        System.out.println();
    }


}
