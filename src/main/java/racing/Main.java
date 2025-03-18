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

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        RacingGame racingGame = new RacingGame(
            cars,
            maxRandomNumber
        );
        ResultView resultView = new ResultView(cars);

        System.out.println("실행 결과\n");
        for (int i = 0; i < tryCount; i++) {
            racingGame.rollTheDice();
            resultView.broadcast();
            System.out.println();
        }
    }
}
