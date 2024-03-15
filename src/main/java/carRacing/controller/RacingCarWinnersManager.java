package carRacing.controller;

import carRacing.model.WinnersName;
import carRacing.model.RacingRecodes;
import carRacing.view.InputView;
import carRacing.view.ResultView;

public class RacingCarWinnersManager {

    public void raceWinner(){

        RacingRecodes records = new RacingRecodes();
        WinnersName winnersName = new WinnersName();

        // 입력
        String[] carNames = inputCarNames();
        int raceCount = InputView.inputNumber(InputView.numberOfRace());

        records.registerCar(carNames);

        // 출력
        ResultView.printRacingResult();

        for (int i = 0; i < raceCount ; i++){
            records.runOneRound();
            ResultView.printRacingCarName(records.recordsOfCars());
        }

        ResultView.WinnerOfRacing(winnersName.findWinner(records.recordsOfCars()));
    }

    public String[] inputCarNames(){
        String inCarName = InputView.inputName(InputView.nameOfCar());
        return inCarName.split(",");
    }
}
