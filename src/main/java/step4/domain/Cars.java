package step4.domain;

import step4.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final List<Car> carList = new ArrayList<>();

    public Cars(String[] nameArr, MovingStrategy movingStrategy) {
        for (String name : nameArr) {
            add(new Car(name, movingStrategy));
        }
    }

    Cars(String[] nameArr, int[] distanceArr) {
        for (int i = 0; i < nameArr.length; i++) {
            add(new Car(nameArr[i], distanceArr[i]));
        }
    }

    public int carCount() {
        return carList.size();
    }

    public void add(Car car) {
        carList.add(car);
    }

    public List<Integer> race() {
        List<Integer> resultPerRound = new ArrayList<>();
        for (Car car : carList) {
            car.move();
            resultPerRound.add(car.distance());
        }

        return Collections.unmodifiableList(resultPerRound);
    }

    public List<String> findWinners() {
        List<String> winnerList = new ArrayList<>();
        int maxDistance = findMaxDistance();
        for (Car car : carList) {
            addWinner(winnerList, car, maxDistance);
        }

        return winnerList;
    }

    private void addWinner(List<String> winnerList, Car car, int maxDistance) {
        if (car.distance() == maxDistance) {
            winnerList.add(car.name());
        }
    }
    private int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : carList) {
            maxDistance = compareDistance(maxDistance, car.distance());
        }

        return maxDistance;
    }

    private int compareDistance(int distance1, int distance2) {
        return Math.max(distance1, distance2);
    }
}
