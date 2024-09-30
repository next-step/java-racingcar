package step3;

import static step3.ResultView.printGoDistance;

import java.util.List;

public class Race {
    private List<Car> carList;
    private int tryCount;

    public Race(List<Car> carList, int tryCount) {
        this.carList = carList;
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
}
