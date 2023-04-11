package step3;

import java.util.List;
import java.util.Random;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomNum = getRandomNumber();
            car.move(randomNum);
        }
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void printCarsScore() {
        for (Car car : cars) {
            car.printProgress();
        }
        System.out.println("");
    }
}
