package RacingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private int time;
    private List<Car> cars;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Car> arrayWithCar(int carCount) {
        ArrayList<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isMoveCar(int randomNumber) {
        if(randomNumber > 4){
            return true;
        }

        return false;
    }
}
