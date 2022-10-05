package step3.domain;

import java.util.List;

public class GameInfo {

    private final List<Car> carList;
    private final int count;

    public GameInfo(List<String> names, int count) {
        this.carList = createCarList(names);
        this.count = count;
    }

    private List<Car> createCarList(List<String> names) {
        Cars cars = new Cars(names);
        List<Car> list = cars.getCarList();
        return list;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getCount() {
        return count;
    }
}
