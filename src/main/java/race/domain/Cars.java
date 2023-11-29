package race.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    private int maxPosition = 0;

    public void initCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition(){
        return maxPosition;
    }
    public void setMaxPosition(int position) {
        if (maxPosition < position) {
            maxPosition = position;
        }
    }

}
