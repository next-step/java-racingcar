package study.step4.try2.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getMax() {
        int length = this.cars.size();
        int max = this.cars.get(0).getPosition();
        for (int i = 1; i < length; i++) {
            if (max < this.cars.get(i).getPosition()) {
                max = this.cars.get(i).getPosition();
            }
        }
        return max;
    }

    public int getMaxTest(Cars cars) {
        List<Car> carList = cars.getCars();
        int length = carList.size();
        int max = carList.get(0).getPosition();
        for (int i = 1; i < length; i++) {
            if (max < carList.get(i).getPosition()) {
                max = carList.get(i).getPosition();
            }
        }
        return max;
    }

    public String getWinners() {
        int length = this.cars.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (this.cars.get(i).getPosition() == getMax()) {
                stringBuilder.append(this.cars.get(i).getCarName());
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString().replaceAll(", $","");
    }

    public String getWinnersTest(Cars cars) {
        List<Car> carList = cars.getCars();
        int length = carList.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (carList.get(i).getPosition() == getMax()) {
                stringBuilder.append(carList.get(i).getCarName());
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString().replaceAll(", $","");
    }
}
