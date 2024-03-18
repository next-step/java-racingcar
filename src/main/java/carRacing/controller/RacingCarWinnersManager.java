package carRacing.controller;

import carRacing.model.RacingRecords;
import carRacing.model.WinnersName;
import carRacing.view.InputView;
import carRacing.view.ResultView;

public class RacingCarWinnersManager {

    public void raceWinner(){

        RacingRecords records = new RacingRecords();
        WinnersName winnersName = new WinnersName();

        records.registerCar(InputView.inputCarNames());
        int raceCount = InputView.inputNumber(InputView.numberOfRace());

        ResultView.printRacingResult();

        for (int i = 0; i < raceCount ; i++){
            ResultView.printRacingCarName(records.raceRecord());
        }

        ResultView.winnerOfRacing(winnersName.findWinner(records.recordsOfCars()));
    }

}
