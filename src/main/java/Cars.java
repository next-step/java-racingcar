import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public List<Car> makeCars(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            cars.add(new Car(strArr[i],0, false));
        }
        return cars;
    }
}