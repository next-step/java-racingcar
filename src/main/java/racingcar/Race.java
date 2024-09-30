package racingcar;

import static racingcar.ResultView.printGoDistance;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> carList = new ArrayList<>();
    private int tryCount;

    public Race(String[] carNameList, int tryCount) {
        makeRacingCar(carNameList);
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void carMove() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).goCar();
            printCarList();
            System.out.println();
        }
    }

    public void printCarList() {
        for (Car car : carList) {
            printGoDistance(car.getDistance());
        }
    }

    private void makeRacingCar(String[] carNameList) {
        for (String carName:carNameList) {
            carList.add(new Car(carName));
        }
    }

}
