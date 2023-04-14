package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;
    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<Integer> valueOfCarsPosition() {
        List<Integer> currentPositions = new ArrayList<>();
        for (Car car : carList) {
            currentPositions.add(car.valueOfCurrentPosition());
        }
        return currentPositions;
//        return carList.stream().map(Car::valueOfCurrentPosition)
//                .collect(Collectors.toList());
    }

    public RoundResult race(List<Integer> randomNumberList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            result.add(findCarByIndex(i).race(randomNumberList.get(i)));
        }
        return new RoundResult(result);
    }

    private Car findCarByIndex(int i) {
        return carList.get(i);
    }

    public int countTotalCar() {
        return carList.size();
    }
}
