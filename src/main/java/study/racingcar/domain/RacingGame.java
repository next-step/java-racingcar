package study.racingcar.domain;

public class RacingGame {
    private static final int MIN_TRY = 1;
    private Cars cars;
    private MovableDistance movableDistance;

    public RacingGame(Cars cars,
                      MovableDistance movableDistance) {
        this.cars = cars;
        this.movableDistance = movableDistance;
    }

    public RacingGameResult play(int time) {
        if (time < MIN_TRY) {
            throw new IllegalArgumentException(
                    String.format("시도 횟수는 %d 이상이여야 합니다.", MIN_TRY));
        }
        RacingGameResult racingGameResult = new RacingGameResult();
        Cars event;
        for (int i = 0; i < time; i++) {
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
