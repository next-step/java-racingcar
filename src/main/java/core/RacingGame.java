package core;

public class RacingGame {
    private PowerSupply powerSupply;

    public RacingGame(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Cars play(Cars cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            cars = cars.moveBy(powerSupply);
        }
        return cars;
    }
}
