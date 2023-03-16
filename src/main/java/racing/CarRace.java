package racing;

import java.util.Random;

public class CarRace {
    Winners getWinners(Cars cars) {
        return new Winners(cars.getFastCars());
    }

    public void racing(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            cars.racingCars(i, getRandomNumber());
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }
}