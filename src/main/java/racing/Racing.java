package racing;

import java.util.*;

public class Racing {
    private List<Car> cars;
    private int numberOfPlay;

    public Racing(String carNames, int numberOfPlay) {
        cars = insertCars(splitCarNames(carNames));
        this.numberOfPlay = numberOfPlay;
    }
    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public List race() {
        for (int play = 0; play < numberOfPlay; play++) {
            random();
        }

        List<String> winner = printWinner();

        return winner;
    }

    public void checkSame(List<String> winners, Car toCompare, Car winner) {
        if (winner.getMovingRange() == toCompare.getMovingRange() && toCompare != winner) {
            winners.add(toCompare.getName());
            System.out.print(", " + toCompare.getName());
        }
    }

    public List<String> printWinner() {

        Collections.sort(cars);
        List<String> winner = new ArrayList<>();

        winner.add(cars.get(0).getName());
        System.out.print("최종 우승자: " + winner.get(0));

        for (Car car: cars) {
            checkSame(winner, car, cars.get(0));
        }
        System.out.println();

        return winner;
    }

    public void random() {
        Random random = new Random();
        for (Car car: cars) {
            moved(random.nextInt(10), car);
            System.out.print(car.getName() + " : ");
            printTrace(car);
            System.out.println();
        }
    }
    /*
    public void random(int mustMove) {
        int count = 0;
        for(Car car: cars) {
            moved(mustMove + count, car);
            System.out.println(car.getName() + " : ");
            printTrace(car);
            System.out.println();
            count++;
        }
    }
     */

    public void moved(int random, Car car) {
        if (random > 4) car.moved();
    }


    private void printTrace(Car aCar) {
        for (int i = 0; i < aCar.getMovingRange(); i++) {
            System.out.print("-");
        }
    }

    private List<Car> insertCars(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();

        for (String carName: carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public String[] splitCarNames(String carNames) { return carNames.split(","); }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();

        for(Car car: cars) {
            carNames.add(car.getName());
        }

        return carNames;
    }
    public List<Car> getCars() { return cars;}
}
