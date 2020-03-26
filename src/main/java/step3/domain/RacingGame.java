package step3.domain;

public class RacingGame {
    private int roundTime;
    private Cars cars;
    private MoveRule moveRule;

    public RacingGame(int roundTime, String[] carNames) {
        this.cars = new Cars(carNames);
        this.roundTime = roundTime;
    }

    public void start() {
        for(int i = 0; i < this.roundTime; i++) {
            cars.moveCars(i, moveRule);
        };
    }

    public void end() {
        this.cars.clear();
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


