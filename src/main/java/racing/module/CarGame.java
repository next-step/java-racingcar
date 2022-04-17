package racing.module;

import exception.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarGame {
    private final List<Car> carList = new ArrayList<>();

    public CarGame(String carName) throws CustomException {
        String[] names = carName.split(",");

        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public void play(MoveStrategy strategy) {
        for (Car car : carList) {
            car.attempt(strategy);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinner() {
        return carList.stream().filter(v -> v.getPosition() == getMaxPosition()).collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return carList.stream().mapToInt(Car::getPosition).max().orElseThrow(NoSuchElementException::new);
    }
}
