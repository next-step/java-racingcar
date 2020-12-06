package racing;

public class GameRunner {
    private Cars cars;
    private int requestMoveCount;

    public GameRunner(Cars cars, int requestMoveCount) {
        this.cars = cars;
        this.requestMoveCount = requestMoveCount;
    }

    public Cars play(RandomNumberGenerator randomNumGenerator) {
        for(int i = 0; i < requestMoveCount; i++) {
            cars.run(randomNumGenerator);
        }
        return cars;
    }
}
