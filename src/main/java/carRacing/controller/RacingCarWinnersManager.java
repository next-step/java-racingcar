package carRacing.controller;

import carRacing.model.RacingRecords;
import carRacing.model.RandomGenerator;
import carRacing.model.RandomMoveStrategy;
import carRacing.model.WinnersName;
import carRacing.view.InputView;
import carRacing.view.ResultView;

public class RacingCarWinnersManager {

    private final static RandomGenerator RANDOM_GENERATOR = new RandomGenerator();
    public void raceWinner(){

        RacingRecords records = new RacingRecords();
        WinnersName winnersName = new WinnersName();

        records.registerCar(InputView.inputCarNames());
        int raceCount = InputView.inputNumber(InputView.numberOfRace());

        ResultView.printRacingResult();

        for (int i = 0; i < raceCount ; i++){
            ResultView.printRacingCarName(records.raceRecord(new RandomMoveStrategy(RANDOM_GENERATOR)));
        }

        ResultView.winnerOfRacing(winnersName.findWinner(records.recordsOfCars()));
    }

}
