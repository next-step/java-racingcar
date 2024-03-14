package racingCar.findWinners;

import racingCar.utils.Utils;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class RacingRecordsWithWinner {
    public void runRaceWithWinner(){
        RecordOfFindWinnerRacing records = new RecordOfFindWinnerRacing();
        NameOfWinners nameOfWinner = new NameOfWinners();

        records.enrollCar(findCarNames());

        int roundNum = Utils.toInt(InputView.numberOfRound());
        OutputView.printRacingResult();
        for (int i = 0; i < roundNum ; i++) {
            records.runOneRound();
            OutputView.printRacingWithName(records.recordsOfCars());
        }
        OutputView.WinnerOfRacing(nameOfWinner.findWinner(records.recordsOfCars()));
    }

    private String[] findCarNames(){
        String carNameString = InputView.nameOfCar();
        return carNameString.split(",");
    }
}
