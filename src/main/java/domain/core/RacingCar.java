package domain.core;

import java.util.List;

/**
 * 일급 컬렉션
 */
public class RacingCar {
    private final List<Car> cars;

    public RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public void playAll(int move) {
        for (int i = 0; i < move; i++) {
            printCar();
        }
    }

    private void printCar() {
        for (Car car : cars) {
            car.play();
            System.out.printf("%s: %s%n", car.getName(), car.getGoString());
        }
        System.out.println();
    }

    public void printWinner() {
        int rank = getRank();
        for (int i = 0; i < rank; i++) {
            System.out.print(cars.get(i).getName() + " ");
        }
        System.out.println("승리하였습니다.");
    }

    private int getRank() {
        sortCars();
        int rank = 0;
        for (Car car : cars) {
            rank = rankCoWin(rank, car);
        }
        return rank;
    }

    private void sortCars() {
        cars.sort((firstCar, secondCar) -> {
            int firstGoCount = firstCar.getGoCount();
            int secondGoCount = secondCar.getGoCount();
            return Integer.compare(secondGoCount, firstGoCount);
        });
    }

    private int rankCoWin(int rank, Car car) {
        if (cars.get(0).getGoCount() == car.getGoCount()) {
            rank++;
        }
        return rank;
    }
}
