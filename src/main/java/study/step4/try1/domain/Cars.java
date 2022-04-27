package study.step4.try1.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {
    private List<Car> cars;

    public Cars(String carNameWithComma) {
        this.cars = new ArrayList<>();
        String[] carNameArray = carNameWithComma.split(",");
        for (String carName : carNameArray) {
            this.cars.add(new Car(carName, 0));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(cars, cars.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
