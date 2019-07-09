package racing.model;


import racing.util.CarCondition;

public class RacingGame {

    private Cars cars;
    private Result result;

    public RacingGame(Cars cars) {
        this.cars = cars;
        this.result = new Result();
    }

    public void play() {
        this.cars.getCars()
                .forEach(car -> car.move(CarCondition.get()));
        result.collect(cars);
    }

    public Result getResult() {
        return result;
    }

    public Cars getCars() {
        return cars;
    }
}
