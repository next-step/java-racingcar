package racingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private int gameCount;

    public void setParticipateCount(int participateCount) {
        verifyCount(participateCount);
        cars = new Cars(generateCarList(participateCount));
    }

    private List<Car> generateCarList(int participateCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < participateCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void setGameCount(int gameCount) {
        verifyCount(gameCount);
        this.gameCount = gameCount;
    }

    private void verifyCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Positions> start() {
        RandomNumber randomNumber = new RandomNumber();
        List<Positions> positionsList = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            cars.start(randomNumber);
            positionsList.add(cars.getPositions());
        }
        return positionsList;
    }
}
