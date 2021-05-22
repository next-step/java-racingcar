package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    static final int NAME_LENGTH = 5;
    static final int MAX_RANDOM = 10;
    static final String CAR_NAME_SPLIT = ",";
    static Random random = new Random();
private RoundCars roundCars = new RoundCars();
    private Cars cars;
    private int tryNo;

    public RacingGame(String carNames, int tryNo) {
        Cars cars = getCars(getCarName(carNames));
        this.cars = cars;
        this.tryNo = tryNo;
    }

    private Cars getCars(String[] carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public String[] getCarName(String carNamesStr) {
        String[] carNames = carNamesStr.split(CAR_NAME_SPLIT);
        for (String carName : carNames) {
            if (carName.length() > NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이내로 .");
            }
        }
        return carNames;
    }

    public void race() {
        Cars newCars = new Cars();
        for (Car car : cars) {
            newCars.add(car.getRandomMove(random.nextInt(MAX_RANDOM), car));
        }
       roundCars.addRound(newCars);
        this.cars = newCars;
    }


    public RoundCars getRoundCars() {
        return roundCars;
    }

    public boolean isEnd() {
        tryNo--;
        return tryNo < 0;
    }

    public List<String> getWinners() {
        Winners winners = new Winners(cars);
        return winners.winners();
    }
}
