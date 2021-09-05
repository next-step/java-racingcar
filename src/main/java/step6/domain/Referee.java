package step6.domain;

import java.util.ArrayList;

public class Referee {
    private final Cars cars;

    private ArrayList<String> winnerCars = new ArrayList<>();
    private int maxPosition = 0;

    public Referee(Cars cars) {
        this.cars = cars;
    }

    public void calculateResults() {
        findMaxposition();
        findWinner();
    }

    private void findWinner() {
        cars.getCars()
                .stream()
                .forEach(car -> findWinnerCar(car));
    }

    private void findMaxposition() {
        cars.getCars()
                .stream()
                .forEach(car -> findMaxPositionByCar(car));
    }

    private void findMaxPositionByCar(Car car) {
        if (car.getPosition() == maxPosition) {
            winnerCars.add(car.getCarName());
        }
    }

    public void findWinnerCar(Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
    }

    public ArrayList<String> getWinnerCars() {
        return winnerCars;
    }
}
