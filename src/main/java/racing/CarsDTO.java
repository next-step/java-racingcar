package racing;

import java.util.ArrayList;
import java.util.List;

public class CarsDTO {

    private List<Integer> cars;

    public CarsDTO() {
        cars = new ArrayList<>();
    }

    public void add(int position){
        cars.add(position);
    }

    public List<Integer> getCars() {
        return this.cars;
    }
}
