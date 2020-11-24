package racingcarwinner;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList();

    private Cars(){}

    public Cars(String names){
        for (String name : Splitter.splitName(names)) {
            cars.add(new Car(name));
        }
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int getCount(){
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars cars1 = (Cars) o;

        return cars.equals(cars1.cars);
    }

    @Override
    public int hashCode() {
        return cars.hashCode();
    }
}
