package step3.domain;

public class GameEnvironment {

    private Integer tryCount;
    private Cars cars;

    public GameEnvironment(Integer carCount, Integer tryCount) {
        this.cars = new Cars(carCount);
        this.tryCount = tryCount;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public Cars getCars() {
        return cars;
    }
}
