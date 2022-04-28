package study.step5.try3.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

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
        int length = cars.size();
        int max = cars.get(0).getPosition();
        for (int index = 1; index < length; index++) {
            max = checkMax(max, index);
        }
        return max;
    }

    private int checkMax(int max, int index) {
        if (max < cars.get(index).getPosition()) {
            max = cars.get(index).getPosition();
        }
        return max;
    }

    public String getWinners() {
        int length = this.cars.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            appendResultMessage(stringBuilder, i);
        }
        return stringBuilder.toString().replaceAll(", $","");
    }

    private void appendResultMessage(StringBuilder stringBuilder, int i) {
        if (this.cars.get(i).getPosition() == getMax()) {
            stringBuilder.append(this.cars.get(i).getCarName());
            stringBuilder.append(", ");
        }
    }

}
