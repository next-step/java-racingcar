package racing;

import exception.CarLocationException;
import util.RacingValidator;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

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
            oneCarRace(i);
        }
    }

    private void oneCarRace(int idx) throws CarLocationException {
        Integer randomNumber = RandomNumberGenerator.getRandomNumber();
        if (RacingValidator.isMovable(randomNumber)) {
            Location newCarLocation = carList.get(idx).getCarLocationInfo().moveForward();
            carList.remove(idx);
            carList.add(idx, new Car(newCarLocation));
        }
    }
}
