package car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static void main(String args[]) {
        InputValue inputValue = InputValue.getValue();
        gameStart(setCars(inputValue.getCarCount()), inputValue.getTryCount());
    }

    static List<Car> setCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        int i=0;

        while (i < carCount) {
            cars.add(new Car());
            i++;
        }

        return cars;
    }

    private static void gameStart(List<Car> cars, int tryCount) {
        int i = 0;

        while (i < tryCount) {
            PrintGameStatus.carsStatus(playingGame(cars));
            i ++;
        }
    }

    static List<Car> playingGame(List<Car> cars) {
        for (Car aCar : cars) {
            aCar.move(RandomNumber.getNumber());
        }

        return cars;
    }
}
