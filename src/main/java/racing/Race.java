package racing;

import java.util.List;

public class Race {
    private int numberOfLaps;
    private List<Car> cars;


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

    public void startRacing() {
        ResultView.displayRaceStart();

        for(int i = 0; i < getNumberOfLaps(); i++) {
            ResultView.displayCar(getCars());
            performLap();
        }

        ResultView.displayRaceFinish();
    }

    private void performLap() {
        for(Car car: cars) {
            car.move();
        }
    }
}
