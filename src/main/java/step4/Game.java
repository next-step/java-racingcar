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
        CarRacing game = new CarRacing(inputData.getPlayers(), inputData.getNumTry());
        RecordGroup recordGroup = new RecordGroup(game.carRacing(game.createCarList(), randomMoveStrategy));
        resultView.printDistanceOfPlayers(recordGroup.getAllRecords());
        resultView.printFinalWinner(recordGroup);
    }
}
