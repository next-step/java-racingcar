package step4;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;


    public static Cars of(String[] names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return new Cars(carList);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(Dice dice) {
        for (Car car : cars) {
            int randomNum = dice.getNum();
            car.move(randomNum);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getBestScore() {
        int bestScore = 0;
        for (Car car : cars) {
            bestScore = Math.max(car.getProgress(), bestScore);
        }
        return bestScore;
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
        if (car.getProgress() == bestScore) {
            winners.add(car.getName());
        }
    }
}
