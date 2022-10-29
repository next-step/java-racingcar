package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(List<String> carNames) {
        for(int i=0; i<carNames.size();i++){
            carList.add(new Car(i+1,carNames.get(i)));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
