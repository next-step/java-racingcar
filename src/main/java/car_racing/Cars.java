package car_racing;

import java.util.Objects;

public class Cars {
    private final Car[] carsForGame;
    private static final String ONE_ROUND_ENDS = "\n";

    /* test */
    public Cars(Car[] cars) {
        this.carsForGame = cars;
    }

    public Cars(int numberOfCars) {
        carsForGame = new Car[numberOfCars];

        for(int i = 0; i < numberOfCars; i++) {
            carsForGame[i] = new Car();
        }
    }

    public void playOneRound() {
        for(Car car: carsForGame) {
            car.move();
        }
    }

    public String getCarsCurrStatuses() {
        StringBuilder carsCurrStatuses = new StringBuilder();
        for(Car car: carsForGame) {
            carsCurrStatuses.append(car.getCurrStatus());
            carsCurrStatuses.append(ONE_ROUND_ENDS);
        }
        carsCurrStatuses.append(ONE_ROUND_ENDS);

        return carsCurrStatuses.toString();
    }

    /* test */
    public int getCarCount() {
        if (Objects.nonNull(carsForGame)) {
            return carsForGame.length;
        }
        return 0;
    }
}
