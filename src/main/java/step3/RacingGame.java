package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private int roundTime;
    private int carCount;
    private Cars cars;
    private List<String> winnerNames;
    private MoveRule moveRule;

    public RacingGame(int roundTime, String[] carNames) {
        this.cars = new Cars(carNames);
        this.carCount = carNames.length;
        this.roundTime = roundTime;
        this.winnerNames = new ArrayList<String>();
    }

    public void start() {
        play();
        this.winnerNames = cars.getWinner();
    }

    public void end() {
        this.cars.clear();
    }

    private void play() {
        for(int i = 0; i < this.roundTime; i++) {
            moveCars(i);
        }
    }

    private void moveCars(int presentRoundTime) {
        CarsIterator carsIterator = new CarsIterator(this.cars);
        while(carsIterator.hasNext()) {
            moveCar(carsIterator.next(), presentRoundTime);
        }
    }

    private void moveCar(Car car, int presentRoundTime) {
        if(moveRule.canMove()) {
            car.move(presentRoundTime);
        }
        car.completeRound(presentRoundTime);
    }

    public int getRoundTime() {
        return roundTime;
    }

    public Cars getCars() {
        return cars;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public void setMoveRule(MoveRule moveRule) {
        this.moveRule = moveRule;
    }
}


