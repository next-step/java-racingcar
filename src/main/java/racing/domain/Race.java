package racing.domain;

import racing.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return getCarByPosition(getMaxPosition());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.max(0))
                .max()
                .orElse(0);
    }

    private List<Car> getCarByPosition(int position) {
        return cars.stream()
                .filter(car -> car.isSamePosition(position))
                .collect(Collectors.toList());
    }

    private void performLapAndDisplay() {
        System.out.println("실행 결과");
        ResultView.displayCar(getCars());

        IntStream.range(0, getNumberOfLaps() - 1)
                .forEach(i -> {
                    performLap();
                    ResultView.displayCar(getCars());
                });
    }

    private void performLap() {
        for(Car car: cars) {
            car.move();
        }
    }
}
