package step5.domain;


import step5.utils.RandomGenerator;

import java.util.Arrays;


public class CarRacing {

    private Cars cars;

    public CarRacing(String[] drivers) {
        this.cars = new Cars(Arrays.asList(drivers));
    }

    public Cars getCurrentStatus() {
        return cars;
    }

    public void moveProgress(RandomGenerator randomGenerator) {
        cars.move(randomGenerator);
    }

    public WinnersResponse getWinner() {
        return new WinnersResponse(cars.getWinners());
    }
}
