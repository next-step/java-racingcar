package RacingCar;

import java.util.*;

public class Racing {
    private int round;
    private List<Car> carList;

    public Racing(int carCount, int round) {
        initCarList(carCount);
        this.round = round;
    }

    private void initCarList(int carCount) {
        carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void round(List<Integer> randomList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            int randomNumber = randomList.get(i);

            car.move(randomNumber);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getRound() {
        return round;
    }
}
