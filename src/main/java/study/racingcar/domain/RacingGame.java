package study.racingcar.domain;

public class RacingGame {
    private Cars cars;
    private MovableDistance movableDistance;

    public RacingGame(Cars cars,
                      MovableDistance movableDistance) {
        this.cars = cars;
        this.movableDistance = movableDistance;
    }

    public RacingGameResult play(Time time) {

        RacingGameResult racingGameResult = new RacingGameResult();
        Cars event;
        for (int i = 0; i < time.getTime(); i++) {
            event = move();
            racingGameResult.addGameEvent(event);
            cars = event;
        }
        racingGameResult.getWinners();

        return racingGameResult;
    }

    public Cars move() {
        Cars event = new Cars();
        int newPosition;
        for (Car car : cars) {
            newPosition = car.addPosition(movableDistance.getDistance());
            event.add(new Car(car.getName(), newPosition));
        }
        return event;
    }
}
