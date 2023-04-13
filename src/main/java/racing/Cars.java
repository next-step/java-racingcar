package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void add(){
        cars.add(new Car());
    }

    public int count() {
        return cars.size();
    }

    public Car find(int i) {
        return cars.get(i);
    }
}
