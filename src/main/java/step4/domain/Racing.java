package step4.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    private Cars cars;

    public static Cars registerCars(String carNames) {
        return new Cars(carNames);
    }

    protected void race() {
        cars.moveOfCars();
    }

    public void numberOfCarMove(int moveCount) {
        IntStream.range(0,moveCount).forEach(i -> race());
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public String getWinners() {
        return cars.getWinnerNames();
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }
}
