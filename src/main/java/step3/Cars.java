package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<Car>();
    
    public Cars(String[] carNames) throws Exception {
        for( String name : carNames ) {
            cars.add(new Car(name));
        }
    }
    
    public int size() {
        return cars.size();
    }
    
    public Car get(int index) {
        return cars.get(index);
    }
}
