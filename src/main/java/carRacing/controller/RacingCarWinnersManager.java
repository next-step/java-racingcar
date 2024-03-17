package carRacing.controller;

import carRacing.model.RacingRecords;
import carRacing.model.WinnersName;
import carRacing.view.InputView;
import carRacing.view.ResultView;

import java.util.List;

public class RacingCarWinnersManager {

    public void raceWinner(){

        RacingRecords records = new RacingRecords();
        WinnersName winnersName = new WinnersName();

        // 입력
        //String[] carNames = inputCarNames();
        List<String> carNames = InputView.inputCarNames();
        int raceCount = InputView.inputNumber(InputView.numberOfRace());

        records.registerCar(carNames);

        // 출력
        ResultView.printRacingResult();

        for (int i = 0; i < raceCount ; i++){
            records.raceRecord();
            ResultView.printRacingCarName(records.recordsOfCars());
        }

        ResultView.winnerOfRacing(winnersName.findWinner(records.recordsOfCars()));
    }

}
