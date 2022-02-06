package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private List<Car> raceResult;
    private TryCount tryCount;
    private List<RaceResult> totalResult;

    public RacingGame(String carNamesInput, int tryCountInput){
        this.cars=new Cars(carNamesInput);
        this.tryCount=new TryCount(tryCountInput);
        this.totalResult=new ArrayList<>();
    }
    public List<RaceResult> startRace(){
        while (tryCount.isPlaying()) {
            raceResult = cars.moveCars();
            totalResult.add(new RaceResult(raceResult));

            tryCount.decreaseTryCount();
        }
        return totalResult;
    }

    public List<Car> getFinalRoundResult(){
        return raceResult;
    }
}
