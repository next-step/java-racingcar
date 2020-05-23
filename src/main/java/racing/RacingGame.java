package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private int car;
    private List<Car> carPositions = new ArrayList<>();

    public void race() {
        car = InputView.inputCar();
        time = InputView.inputTime();

        for (int i = 0; i < car; i++) {
            carPositions.add(new Car(i, 1));
        }

        ResultView.startPosition(carPositions.size());

        for (int i = 0; i < time - 1; i++) {
            moveCar();
            System.out.println();
        }
    }

    public void moveCar() {
        for (int i = 0; i < carPositions.size(); i++) {
            carPositions.get(i).move(RandomNumber.getRandomNumber());

            ResultView.resultGame(carPositions.get(i).position);
        }
    }
}