package racing.domain;

import org.apache.commons.lang3.StringUtils;
import racing.util.Dice;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars() {
        this.carList = new ArrayList<>();
    }

    public RacingCars(String carNames) {
        this();
        joinCars(carNames);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void carsMove() {
        for (Car car : carList) {
            car.move(Dice.cast());
        }
    }

    public RacingCars getDeepCopyRacingCars() {
        List<Car> snapShot = new ArrayList<>();
        for (Car car : carList) {
            snapShot.add(car.deepCopyCar());
        }

        RacingCars snapShotRacingCar = new RacingCars();
        snapShotRacingCar.carList.addAll(snapShot);

        return snapShotRacingCar;
    }

    public int getWinnerPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = getMaxPosition(car.getPosition(), maxPosition);
        }

        return maxPosition;
    }

    private void joinCars(String carNames) {
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            carName = carName.trim();
            validateName(carName);
            this.carList.add(new Car(carName));
        }
    }

    private void validateName(String carName) {
        if (StringUtils.isBlank(carName)) {
            throw new IllegalArgumentException();
        }
    }

    private int getMaxPosition(int position1, int position2) {
        if (position1 >= position2) {
            return position1;
        }

        return position2;
    }
}
