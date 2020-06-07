package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars() {
    }

    public Cars(String carNames) {
        joinCars(carNames);
    }

    public int getJoinedCarCount() {
        return carList.size();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void carsMove(List<Integer> diceResultList) {
        int carCount = carList.size();
        for (int i = 0 ; i < carCount ; i++) {
            carList.get(i).move(diceResultList.get(i));
        }
    }

    public Cars getDeepCopyRacingCars() {
        List<Car> snapShot = new ArrayList<>();
        for (Car car : carList) {
            snapShot.add(car.deepCopyCar());
        }

        Cars snapShotRacingCar = new Cars();
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
            this.carList.add(new Car(carName));
        }
    }

    private int getMaxPosition(int position1, int position2) {
        if (position1 >= position2) {
            return position1;
        }

        return position2;
    }
}
