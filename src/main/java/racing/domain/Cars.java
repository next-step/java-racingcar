package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public Cars(String carNames) {
        joinCars(carNames);
    }

    public int getJoinedCarCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveCars(List<Integer> diceNumberList) {
        int carsCount = cars.size();

        if (diceNumberList.size() != carsCount) {
            throw new IllegalArgumentException("dice number 갯수가 맞지 않습니다.");
        }

        for (int i = 0 ; i < carsCount ; i++) {
            cars.get(i).move(RandomMovingStrategy.isMove(diceNumberList.get(i)));
        }
    }

    public Cars getDeepCopyRacingCars() {
        List<Car> snapShot = new ArrayList<>();
        for (Car car : cars) {
            snapShot.add(car.deepCopyCar());
        }

        Cars snapShotRacingCar = new Cars();
        snapShotRacingCar.cars.addAll(snapShot);

        return snapShotRacingCar;
    }

    public int getWinnerPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = getMaxPosition(car.getPosition(), maxPosition);
        }

        return maxPosition;
    }

    private void joinCars(String carNames) {
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            carName = carName.trim();
            this.cars.add(new Car(carName));
        }
    }

    private int getMaxPosition(int position1, int position2) {
        if (position1 >= position2) {
            return position1;
        }

        return position2;
    }

}
