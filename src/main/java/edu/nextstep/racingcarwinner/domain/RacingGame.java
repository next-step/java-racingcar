package edu.nextstep.racingcarwinner.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> joinedCarList;

    public List<Car> makeCarList(String carNames) {
        List<Car> carList = new ArrayList<>();
        String[] nameArr = carNames.split(",");
        for (String name : nameArr) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void joinGame(List<Car> carList) {
        this.joinedCarList = carList;
    }

    public void playOneRound(){
        for (Car car : joinedCarList) {
            car.move();
        }
    }

    public List<Car> getJoinedCarList() {
        return this.joinedCarList;
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : joinedCarList) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        for (Car car : joinedCarList) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }
}
