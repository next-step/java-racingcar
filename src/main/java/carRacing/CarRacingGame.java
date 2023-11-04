package carRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingGame {

    public static final int MAX = 10;
    private final int carCount;
    private final int raceCount;
    List<Car> carList = new ArrayList<>();

    public CarRacingGame(int carCount, int raceCount) {
        this.carCount = carCount;
        this.raceCount = raceCount;
    }


    public void startGame() {
        init();
        for (int i = 0; i < raceCount; i++) {
            round();
            ResultView.printRoundResult(carList);
        }
    }


    public List<Car> round() {

        for (Car car : carList) {
           move(car);
        }

        return carList;
    }

    public void init() {
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void move(Car car) {
        if (isRide(random())) {
          car.move();
        }
    }


    public List<Car> showCarList() {
        return carList;
    }


    public boolean isRide(int number) {
        if (number < 4) {
            return false;
        }
        return true;
    }

    public int random() {
        Random random = new Random();
        return random.nextInt(MAX);
    }


}
