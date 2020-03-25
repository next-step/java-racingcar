package step3.domain;

import java.util.List;

public class RacingGame {
    private int roundTime;
    private int carCount;
    private Cars cars;
    private MoveRule moveRule;

    public RacingGame(int roundTime, String[] carNames) {
        this.cars = new Cars(carNames);
        this.carCount = carNames.length;
        this.roundTime = roundTime;
    }

    public void start() {
        play();
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
    public void setMoveRule(MoveRule moveRule) {
        this.moveRule = moveRule;
    }
}


