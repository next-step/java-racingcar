package carRacing.controller;

import carRacing.model.MoveStrategy;
import carRacing.model.RacingCar;
import carRacing.model.RandomGenerator;
import carRacing.model.RandomMoveStrategy;
import carRacing.view.InputView;
import carRacing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameManager {

    public void run() {
        // 입력
        int carCount = InputView.inputNumber(InputView.numberOfCar());
        int raceCount = InputView.inputNumber(InputView.numberOfRace());

        List<RacingCar> records = new ArrayList<>();

        for (int i = 0 ; i < carCount ; i++){
            records.add(new RacingCar());
        }

        // 출력
        ResultView.printRacingResult();

        for (int i = 0; i < raceCount ; i++){
            playRound(records);
            ResultView.printRacing(records);
        }
    }

    public void playRound(List<RacingCar> records) {
        for (RacingCar racingCar: records) {
            racingCar.move(moving());
        }
    }

    private static MoveStrategy moving(){
        RandomGenerator randomGenerator = new RandomGenerator();
        return new RandomMoveStrategy(randomGenerator);
    }

}
