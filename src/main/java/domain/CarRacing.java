package domain;

import java.util.*;

public class CarRacing {

    private List<Car> cars;
    private Queue<Integer> executeNumbers = new LinkedList<>();

    public void makingCar(String inputString) {
        String[] names = inputString.split(",");
        this.cars = new ArrayList<>();
        makingNamingCars(names);
        makingExecuteNumbers();
    }

    private void makingNamingCars(String[] names) {
        for (String name : names) {
            Car car = new Car();
            car.makeName(name);
            cars.add(car);
        }
    }

    public int totalCarCount() {
        return cars.size();
    }

    public List<Car> cars() {
        return this.cars;
    }

    public Queue<Integer> executeNumbers() {
        return this.executeNumbers;
    }

    public int executeNumbersCount() {
        return executeNumbers.size();
    }

    public void executeRace() {
        for (Car car : cars) {
            car.move(executeNumbers.poll());
        }
        makingExecuteNumbers();
    }

    private void makingExecuteNumbers() {
        Random random = new Random();
        int carSize = cars.size();
        while (carSize-- > 0) {
            this.executeNumbers.add(random.nextInt(10));
        }
    }

    public List<Car> getWinningRaceCars() {
        int maxPosition = findMaxPosition();
        return findWinningCars(maxPosition);
    }

    private List<Car> findWinningCars(int maxPosition) {
        List<Car> winningCars = new ArrayList<>(cars);
        winningCars.removeIf(it -> !it.isWinningCar(maxPosition));
        return winningCars;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.position(), maxPosition);
        }
        return maxPosition;
    }
}
