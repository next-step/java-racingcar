package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars() {}

    public Cars(String[] nameOfCars) {
        Arrays.stream(nameOfCars)
            .forEach(name -> cars.add(new Car(name)));
    }

    public Cars(List<Integer> positions) {
        positions.forEach(position -> cars.add(new Car(position)));
    }

    public int getNumOfCars() {
        return cars.size();
    }

    public Car findCarBy(int idx) {
        if (isOutOfIndex(idx)) {
            throw new IndexOutOfBoundsException("해당 번호의 차량은 존재하지 않습니다.");
        }

        return cars.get(idx);
    }

    private boolean isOutOfIndex(int idx) {
        return idx >= cars.size() || idx < 0;
    }

    public void moveCarBy(int randomNum, int carNo) {
        cars.get(carNo).moveForward(randomNum);
    }

    public int findMaxPosition() {
        int max = 0;

        for (Car car : cars) {
            max = car.comparePosition(max);
        }

        return max;
    }
}
