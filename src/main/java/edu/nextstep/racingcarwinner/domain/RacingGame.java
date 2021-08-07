/*
 * edu.nextstep.racingcarwinner.domain.RacingGame.java
 * 0.1 2021.08.07 18:24
 * 해당 클래스의 경우 TDD, CleanCode with Java 수업의 RacingCar step4에 해당됩니다.
 */

package edu.nextstep.racingcarwinner.domain;

import edu.nextstep.racingcarwinner.strategy.RacingStrategy;

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

    public void playOneRound(RacingStrategy racingStrategy){
        for (Car car : joinedCarList) {
            car.move(racingStrategy);
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
