package RacingCar.Model;

import RacingCar.View.Input.Input;
import RacingCar.View.Output.Output;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    ArrayList<Car> cars = new ArrayList<Car>();
    private static final int RANDOM_NUM_LIMIT = 10;

    public void roundStart() {
        for (Car car : cars)
            car.move(getRandomNumber(RANDOM_NUM_LIMIT));
    }

    public ArrayList<Car> getWinner() {
        Winner winner = new Winner();
        winner.makeWinner(cars);

        return winner.getWinners();
    }

    public void makeCar(String[] carName) {
        for (int i = 0; i < carName.length; i++)
            cars.add(new Car(0, carName[i]));
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    private static int getRandomNumber(int num) {
        Random random = new Random();
        int result = random.nextInt(num);

        return result;
    }


}
