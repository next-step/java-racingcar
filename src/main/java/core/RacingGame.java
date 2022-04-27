package core;

public class RacingGame {
    private PowerSupply powerSupply;

    public RacingGame(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public PositionBoard play(Cars cars, int moveCount) {
        PositionBoard positionBoard = PositionBoard.create(cars);
        for (int i = 0; i < moveCount; i++) {
            cars = cars.moveBy(powerSupply);
            positionBoard.recordPosition(cars);
        }
        return positionBoard;
    }
}
