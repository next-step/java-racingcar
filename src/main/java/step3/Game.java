package step3;

import step3.domain.CarRacing;
import step3.domain.DistanceStatus;
import step3.domain.MoveStrategy;
import step3.domain.RandomMoveStrategy;
import step3.model.InputData;
import step3.view.InputView;
import step3.view.ResultView;

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
