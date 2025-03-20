package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;
    private int numberOfLaps;


    public Race(List<Car> cars, int numberOfLaps) {
        this.cars = cars;
        this.numberOfLaps = numberOfLaps;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getNumberOfLaps() {
        return this.numberOfLaps;
    }

    public List<Car> startRacingAndReturnWinner() {
        ResultView.displayRaceStart();

        performLapAndDisplay();

        ResultView.displayRaceFinish();

        return getWinners();
    }

    private List<Car> getWinners() {
        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private void performLapAndDisplay() {
        System.out.println("실행 결과");
        ResultView.displayCar(getCars());
        for(int i = 0; i < getNumberOfLaps() - 1; i++) {
            performLap();
            ResultView.displayCar(getCars());
        }
    }

    private void performLap() {
        for(Car car: cars) {
            car.move();
        }
    }
}
