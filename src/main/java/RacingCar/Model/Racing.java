package RacingCar.Model;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {
    private static int RANDOM_NUMBER_RANGE = 10;

    private int round;

    public Racing(int round) {
        this.round = round;
    }

    public void round(Number randomNumber, List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            int random = randomNumber.random(RANDOM_NUMBER_RANGE);

            car.move(random);
        }
    }

    public List<Car> carList(String carInput) {
        List<Car> carList = new ArrayList<>();

        String[] carArray = carInput.split(",");

        init(carArray, carList);

        return carList;
    }

    private void init(String[] carArray, List<Car> carList) {
        for (String carName : carArray) {
            carList.add(new Car(carName, 1));
        }
    }

    public int getRound() {
        return round;
    }
}
