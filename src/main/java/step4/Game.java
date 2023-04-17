package step4;

import step4.domain.CarRacing;
import step4.domain.MoveStrategy;
import step4.domain.RandomMoveStrategy;
import step4.model.InputData;
import step4.model.Record;
import step4.model.RecordGroup;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        InputData inputData = inputView.inputData();
        RecordGroup recordGroup;
        CarRacing cr = new CarRacing(inputData.getPlayers(), inputData.getNumTry());
        List<List<Record>> results = cr.carRacing(cr.createCarList(), randomMoveStrategy);
        System.out.println();
        recordGroup = new RecordGroup(results);
        resultView.printDistanceOfPlayers(results);
        resultView.printFinalWinner(recordGroup);
    }
}
