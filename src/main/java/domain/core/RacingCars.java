package domain.core;

import utils.RandomNumber;

import java.util.List;

import static domain.core.GameOptions.MAX_RANDOM;
import static domain.core.GameOptions.MIN_RANDOM;

/**
 * 일급 컬렉션
 */
public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(int move) {
        for (int i = 0; i < move; i++) {
            moveCar();
        }
    }

    private void moveCar() {
        for (Car car : cars) {
            car.move(new Accelerator(RandomNumber.generateNumber(MIN_RANDOM, MAX_RANDOM)));
            printCar(car);
        }
        System.out.println();
    }

    private void printCar(Car car) {
        System.out.printf("%s: %s%n", car.getName(), car.getDistancePrintMessage());
    }

    public void printWinner() {
        int winnerCount = getWinnerCount();
        StringBuilder sb = new StringBuilder();
        String separator = ", ";
        for (int i = 0; i < winnerCount; i++) {
            sb.append(cars.get(i).getName());
            sb.append(separator);
        }
        sb.delete(sb.length() - separator.length(), sb.length()); //TODO: 마지막 승리자 출력시 (,) 제거 좀 더 나은 방법은 뭐가 있을까?
        sb.append(" 승리하였습니다.");
        System.out.println(sb);
    }

    private int getWinnerCount() {
        sortCarsByDistanceDesc();
        int winnerCount = 0;
        Car WinnerCar = cars.get(0);
        for (Car compareCar : cars) {
            winnerCount = compareCoWin(winnerCount, WinnerCar, compareCar);
        }
        return winnerCount;
    }

    private void sortCarsByDistanceDesc() {
        cars.sort((firstCar, secondCar) -> {
            int firstGoCount = firstCar.getDistance();
            int secondGoCount = secondCar.getDistance();
            return Integer.compare(secondGoCount, firstGoCount);
        });
    }

    private int compareCoWin(int winnerCount, Car WinnerCar, Car car) {
        if (WinnerCar.getDistance() == car.getDistance()) {
            winnerCount++;
        }
        return winnerCount;
    }
}
