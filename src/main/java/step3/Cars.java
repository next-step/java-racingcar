package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;


    public static Cars of(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return new Cars(carList);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(Dice dice) {
        for (Car car : cars) {
            int randomNum = dice.getRandomNum();
            car.move(randomNum);
        }
    }


    public void addCarsScore(List<Integer> scoreList) {
        for (Car car : cars) {
            car.addScore(scoreList);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
