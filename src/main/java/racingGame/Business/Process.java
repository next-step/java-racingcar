package racingGame.Business;

import java.util.ArrayList;
import java.util.List;
import racingGame.Response.GameResult;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;
import racingGame.model.Rules;
import racingGame.util.RandomUtil;

public class Process {
    
    private Rules rules;
    private final List<Car> joinCars = new ArrayList<>();
    private final List<ProgressRecord> progressRecords = new ArrayList<>();
    
    public List<GameResult> run(int cars, int moves) {
        init(cars, moves);
        participateCar();
        moveCar();
        return showResult();
    }
    
    private void init(int cars, int moves) {
        this.rules = new Rules(cars, moves);
    }
    
    private void participateCar() {
        CarFactory carFactory = new CarFactory(this.rules);
        joinCars.addAll(carFactory.createCars());
    }
    
    private void moveCar() {
        while(rules.isLimitMove(this.progressRecords.size())) {
            nextMove();
            recordCarsMove();
        }
    }
    
    private List<GameResult> showResult() {
        List<GameResult> gameResults = new ArrayList<>();
        gameResults.add(new GameResult(this.progressRecords));
        return gameResults;
    }
    
    private void nextMove() {
        for(Car car: this.joinCars) {
            if(car.isForwardByRandom(RandomUtil.generateInt())) {
                car.forward();
            }
        }
    }
    
    private void recordCarsMove() {
        ProgressRecord pr = new ProgressRecord();
        pr.recordGame(this.joinCars);
        progressRecords.add(pr);
    }
    
    public List<Car> joinCars() {
        return this.joinCars;
    }
}