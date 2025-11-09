package racingGame.Business;

import java.util.ArrayList;
import java.util.List;
import racingGame.ResultView;
import racingGame.model.Car;
import racingGame.model.Rules;
import racingGame.util.RandomUtil;

public class Process {
    
    public static final int CAR_FORWARD_CRITERIA = 3;
    private Rules rules;
    private final List<Car> joinCars = new ArrayList<>();
    private int nowMoves;
    
    public void run(int cars, int moves){
        init(cars, moves);
        participateCar();
        
        for(int i = 0; i < moves; i++) {
            nextMove();
            ResultView.moveDonePrint();
        }
    }
    
    private void nextMove() {
        for(Car car: joinCars) {
            ResultView.forwardCarPrint(car.findLocation());
            if(RandomUtil.generateInt() > CAR_FORWARD_CRITERIA) {
                car.move();
            }
        }
    }
    
    public List<Car> joinCars() {
        return this.joinCars;
    }
    
    private void init(int cars, int moves) {
        rules = Rules.of(cars, moves);
    }
    
    private void participateCar() {
        while(rules.isLimitCars(this.joinCars.size())){
            this.joinCars.add(new Car());
        }
    }
}