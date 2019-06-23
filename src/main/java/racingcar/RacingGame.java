package racingcar;

import racingcar.Car;
import racingcar.Cars;

import java.util.*;

public class RacingGame {

    private int numberOfCars;
    private int numberOfGames;
    private Cars carsList;
    private Map<Integer, List<Car>> gameRecord = new HashMap<>();

    RacingGame(int numberOfCars, int numberOfGames) {
        this.numberOfCars = numberOfCars;
        this.numberOfGames = numberOfGames;
    }

    public void carsLineup() {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        carsList = new Cars(cars);
    }

    public Map<Integer, List<Car>> gameStart() {
        List<Car> cars = carsList.getCars();
        for (int i = 0; i < numberOfGames; i++) {
            for (int j = 0; j < numberOfCars; j++) {
                Random random = new Random();
                cars.get(j).move(random.nextInt(10));

            }
            gameRecord.put(i, cars);
        }
        carsList = new Cars(cars);

        return gameRecord;
    }

    public void gameStart2() {
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < numberOfGames; i++) {
            for (Car car : carsList.getCars()) {
                Random random = new Random();
                car.move(random.nextInt(10));
                cars.add(car);
            }
        }
        carsList = new Cars(cars);
    }



}
