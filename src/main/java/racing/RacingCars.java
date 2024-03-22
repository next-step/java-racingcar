package racing;

import exception.CarLocationException;
import util.NumberUtil;
import util.RacingValidator;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> carList;

    public RacingCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(new Location(0)));
        }
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void startRace() throws CarLocationException {
        for (int i = 0; i < this.carList.size(); i++) {
            oneCarRace(i, carList.get(i));
        }
    }

    private void oneCarRace(int idx, Car car) throws CarLocationException {
        Integer randomNumber = RandomNumberGenerator.getRandomNumber();
        if (RacingValidator.isMovable(randomNumber)) {
            Location newCarLocation = car.moveForward();
            carList.remove(idx);
            carList.add(idx, new Car(newCarLocation));
        }
    }

    public List<Car> getWinCarList() {
        int winnerLocation = NumberUtil.getMaxNumberOfList(carList.stream().map(Car::getLocation).collect(Collectors.toList()));
        return carList.stream().filter(car -> car.getLocation() == winnerLocation).collect(Collectors.toList());
    }
}
