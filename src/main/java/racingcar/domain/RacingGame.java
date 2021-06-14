package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static RacingRandom racingRandom = new RacingRandom();

    private Cars cars;
    private int cycle;
    private boolean isEnd;

    public RacingGame(String carNames, int cycle) {
        this.cars = new Cars();
        this.cycle = cycle;
        this.isEnd = false;
        cars = createCarInformation(carNames);
    }

    private Cars createCarInformation(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.addCars(carName);
        }
        return cars;
    }

    public void race() {
        for (int i = 0; i < cycle; i++) {
            move();
        }
        isEnd = true;
    }

    private void move() {
        for (int i = 0; i < cars.getCars().size(); i++) {
            cars.getCars().get(i).move(racingRandom.isMove());
        }
    }

    public boolean isEnd() {
        return isEnd;
    }

    public List<Car> selectWinners() {
        return cars.selectWinners();
    }

    public Cars getCars() {
        return cars;
    }
}
