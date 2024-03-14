package racingCar;

import racingCar.interf.MovingStrategy;
import racingCar.interf.RandomMovingStrategy;
import racingCar.utils.RandomGenerator;
import racingCar.utils.Utils;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingRecords {
    public void runRace(){

        List<RacingCar> records = new ArrayList<>();

        int carNum = Utils.toInt(InputView.numberOfCar());
        int roundNum = Utils.toInt(InputView.numberOfRound());

        for(int i = 0 ; i < carNum ; i++){
            records.add(new RacingCar());
        }

        OutputView.printRacingResult();
        for(int i = 0; i < roundNum ; i++){
            runOneRound(records);
            OutputView.printRacing(records);
        }
    }

    public void runOneRound(List<RacingCar> records) {
        for (RacingCar racingCar: records) {
            racingCar.move(moving());
        }
    }

    private static MovingStrategy moving(){
        RandomGenerator randomGenerator = new RandomGenerator();
        return new RandomMovingStrategy(randomGenerator);
    }



}
