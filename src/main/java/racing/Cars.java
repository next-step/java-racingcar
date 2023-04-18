package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public List<Car> cars;

    public Cars(String inputCarNames) {
        cars = new ArrayList<>();
        for (String carName : splitCarNames(inputCarNames)) {
            add(carName);
        }
    }

    private String[] splitCarNames(String inputCarNames) {
        return inputCarNames.split(",");
    }

    private void add(String name){
        cars.add(new Car(name));
    }

    public int count() {
        return cars.size();
    }

    public Car find(int i) {
        return cars.get(i);
    }
}
