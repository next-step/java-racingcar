package race.step3;

import race.step3.domain.CarRacing;
import race.step3.domain.DistanceStatus;
import race.step3.domain.MoveStrategy;
import race.step3.domain.RandomMoveStrategy;
import race.step3.model.InputData;
import race.step3.view.InputView;
import race.step3.view.ResultView;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        InputData inputData = new InputView().inputData();
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        CarRacing cr = new CarRacing(inputData);
        ArrayList<ArrayList<DistanceStatus>> result = cr.start(randomMoveStrategy);
        new ResultView().printCarsDistance(result);
    }
}
