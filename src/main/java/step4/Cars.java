package step4;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return new Cars(carList);
    }

    public static Cars of(Cars cars) {
        List<Car> carList = new ArrayList<>();
        for (Car car : cars.cars) {
            carList.add(Car.of(car));
        }
        return new Cars(carList);
    }

    public void moveCars(Dice dice) {
        for (Car car : cars) {
            int moveNumber = dice.getNum();
            car.move(moveNumber);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getBestScore() {
        int bestScore = 0;
        for (Car car : cars) {
            bestScore = car.getBigerProgress(bestScore);
        }
        return bestScore;
    }

    public void moveCar(int position, int value) {
        cars.get(position).moveCar(value);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car);
        }
        return winners;
    }

    private void addWinner(List<String> winners, Car car) {
        int bestScore = getBestScore();
        if (car.isEqualsProgress(bestScore)) {
            winners.add(car.getName());
        }
    }
}
