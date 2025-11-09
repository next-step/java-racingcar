package racingGame.Business;

import java.util.ArrayList;
import java.util.List;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;
import racingGame.model.Rules;
import racingGame.util.RandomUtil;

public class Process {
    
    private Rules rules;
    private final List<Car> joinCars = new ArrayList<>();
    private final List<ProgressRecord> progressRecords = new ArrayList<>();
    
    public List<List<Integer>> run(int cars, int moves) {
        init(cars, moves);
        participateCar();
        moveCar();
        return showResult();
    }
    
    private void init(int cars, int moves) {
        rules = Rules.of(cars, moves);
    }
    
    private void participateCar() {
        while(rules.isLimitCars(this.joinCars.size())) {
            this.joinCars.add(new Car());
        }
    }
    
    private void moveCar() {
        while(rules.isLimitMove(this.progressRecords.size())) {
            nextMove();
            recordCarsMove();
        }
    }
    
    private List<List<Integer>> showResult() {
        List<List<Integer>> results = new ArrayList<>();
        for(ProgressRecord pr: progressRecords) {
            List<Integer> result = pr.gameSimpleResult();
            results.add(result);
        }
        return results;
    }
    
    private void nextMove() {
        for(Car car: this.joinCars) {
            if(rules.isProceedByRandom(RandomUtil.generateInt())) {
                car.move();
            }
        }
    }
    
    private void recordCarsMove() {
        ProgressRecord pr = new ProgressRecord();
        pr.gameRecord(this.joinCars);
        progressRecords.add(pr);
    }
    
    public List<Car> joinCars() {
        return this.joinCars;
    }
}