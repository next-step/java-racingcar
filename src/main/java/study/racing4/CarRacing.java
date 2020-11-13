package study.racing4;

import java.util.List;

public class CarRacing {

    private final CarCollection cars;
    private final int lastRound;
    private final MovingStrategy moveable;

    private int currentRound = 0;

    public CarRacing(RacingInput racingInput, MovingStrategy moveable) {
        this.cars = new CarCollection(racingInput.getCars());
        this.lastRound = racingInput.getCountOfRound();
        this.moveable = moveable;
    }

    public boolean isProcessAbleRound() {
        return (currentRound < lastRound);
    }

    public void processRound() {

        if (!isProcessAbleRound()) {
            throw new RuntimeException("더 이상 라운드를 진행 할 수 없습니다.");
        }

        cars.apply( car -> {
            if(moveable.moveable()) car.move();
        });
        currentRound++;
    }

    public CarCollection getCars() {
        return cars;
    }

    public List<Car> getWinnerCar() {

        int maxPosition = cars.getMaxPosition();
        return cars.matchedPositionCars(maxPosition);
    }

}
