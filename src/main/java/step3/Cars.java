package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars() {}

    public Cars(int numOfCars) {
        for (int i=0; i<numOfCars; i++) {
            cars.add(new Car());
        }
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
}
