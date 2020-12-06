package racing;

public class GameRunner {
    private Cars cars;
    private int requestMoveCount;

    public GameRunner(Cars cars, int requestMoveCount) {
        this.cars = cars;
        this.requestMoveCount = requestMoveCount;
    }

    public Cars play(RandomNumberGenerator randomNumGenerator) {
        ViewResult viewResult = new ViewResult();
        viewResult.showFirstLine();
        for(int i = 0; i < requestMoveCount; i++) {
            Cars results = cars.run(randomNumGenerator);
            viewResult.view(results);
        }
        return cars;
    }
}
