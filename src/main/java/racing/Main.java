package racing;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {
        int carCount = InputView.getCarCount();

        int tryCount = InputView.getTryCount();

        int maxRandomNumber = InputView.getMaxRandomNumber();

        List<Car> simpleCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            simpleCars.add(new SimpleCar());
        }

        RacingGame racingGame = new RacingGame(
            simpleCars,
            maxRandomNumber
        );
        ResultView resultView = new ResultView(simpleCars);

        System.out.println("실행 결과\n");
        for (int i = 0; i < tryCount; i++) {
            racingGame.rollTheDice();
            resultView.broadcast();
            System.out.println();
        }
    }
}
