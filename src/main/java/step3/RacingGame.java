package step3;

public class RacingGame {
    int carCount, tryCount;
    Cars cars;

    public RacingGame(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        cars = Cars.of(carCount);
    }

    public void race(Dice dice, ResultView outputView) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(dice);
            cars.printCarsScore(outputView);
        }
    }


}
