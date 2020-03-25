package racing.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int MAX_RANDOM_VALUE = 10;
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

    public void playRound() {
        Random random = new Random(System.currentTimeMillis());

        for (Car car : cars) {
            car.moveByCondition(random.nextInt(MAX_RANDOM_VALUE));
        }
    }
}
