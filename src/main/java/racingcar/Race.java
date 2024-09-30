package racingcar;

import static racingcar.ResultView.printGoDistance;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> carList = new ArrayList<>();
    private int tryCount;
    private int maxDistance;

    public Race(String[] carNameList, int tryCount) {
        makeRacingCar(carNameList);
        this.tryCount = tryCount;
        this.maxDistance = 0;
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
        }
        printCarList();
        System.out.println();
    }

    public void printCarList() {
        for (Car car : carList) {
            printGoDistance(car);
        }
    }

    private void makeRacingCar(String[] carNameList) {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    public void setMaxDistance() {
        for (Car car : carList) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public List<String> getWinnerCarList() {
        List<String> winnerCarList = new ArrayList<>();
        for (Car car : carList) {
            addWinner(winnerCarList, car);
        }
        return winnerCarList;
    }

    public void addWinner(List<String> winnerCarList, Car car) {
        if (car.getDistance() == maxDistance) {
            winnerCarList.add(car.getCarName());
        }
    }
}
