package step5.view;

import step5.domain.Cars;
import step5.domain.stretagy.SimpleRandomMovingStrategy;

import java.util.List;

public class GameLauncher {

    public static void main(String[] args) {
        Cars cars = new Cars();
        SimpleResultView raceResult = new SimpleResultView("-");

        List<String> names = View.getNameOfCars();
        int tryCount = View.getTryCount();
        View.printStart();

        cars.setUp(names, new SimpleRandomMovingStrategy());
        for (int i = 0; i < tryCount; i++) {
            cars.race();
            View.printEachResult(cars.getNowResult(raceResult));
        }
        View.printWinner(cars.getWinners());
    }

}
