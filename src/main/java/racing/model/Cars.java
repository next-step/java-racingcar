package racing.model;

import racing.strategy.GoStraightStrategy;
import racing.strategy.RandomNumberGoStraightStrategy;
import racing.view.GameOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static final String COMMA = ",";
    private static final String REMOVE_LAST_COMMA_REGEX = ",$";
    private static final String BLANK = "";

    private List<Car> cars;
    private boolean isSort;

    public Cars(List<Car> cars) {
        this.cars = cars;
        this.isSort = false;
    }

    public String getNameInCarList() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName());
            sb.append(COMMA);
        }
        return removeComma(sb.toString());
    }

    public void playRound() {
        final GoStraightStrategy randomStraightStrategy = RandomNumberGoStraightStrategy.getInstance();
        for (Car car : cars) {
            car.goStraight(randomStraightStrategy);
            GameOutput.printCurrentLocationAndCarName(car);
        }
    }

    public int getWinnerLocation() {
        if (!isSort) {
            this.sort();
        }
        return this.cars.get(0).getCurrentLocation();
    }

    public Cars getWinner(int winnerLocation) {
        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (isNotWinnerCar(winnerLocation, car)) {
                return new Cars(winner);
            }
            winner.add(car);
        }
        return new Cars(winner);
    }

    public Car getCar(int idx){
        return this.cars.get(idx);
    }

    private String removeComma(String string) {
        return string.replaceAll(REMOVE_LAST_COMMA_REGEX, BLANK);
    }

    private static boolean isNotWinnerCar(int winnerLocation, Car car) {
        return car.getCurrentLocation() < winnerLocation;
    }

    private void sort() {
        Collections.sort(this.cars);
        this.isSort = true;
    }

}
