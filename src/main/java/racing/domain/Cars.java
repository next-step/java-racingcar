package racing.domain;


import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(int carNum) {
        cars = new ArrayList<>();

        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
    }

    public Cars(List<Car> carsList) {
        cars = carsList;
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getList() {
        return cars;
    }

    public List<Integer> getCarsPositionList() {
        List<Integer> positionList = new ArrayList<>();

        for (Car car : cars) {
            positionList.add(car.getPosition());
        }

        return positionList;
    }
}
