package race.step4;

import race.step4.domain.CarRacing;
import race.step4.domain.MoveStrategy;
import race.step4.domain.RandomMoveStrategy;
import race.step4.model.InputData;
import race.step4.model.RecordGroup;
import race.step4.view.InputView;
import race.step4.view.ResultView;

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
