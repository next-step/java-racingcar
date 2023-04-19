package racing.controller;

import racing.model.Car;
import racing.model.Cars;
import racing.view.ResultView;

import java.util.List;

public class RaceGame {

    public void startRacing(int carNum, int attempts) {
        Cars cars = new Cars(carNum);

        for (int i = 0; i < attempts; i++) {
            ResultView.printRoundResult((cars.move()));
        }

    }

}
