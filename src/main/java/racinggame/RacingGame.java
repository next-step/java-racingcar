package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(int carCount) {
        ArrayList<Car> cars = new ArrayList<>();
        for(int i=0;i<carCount;i++){
            cars.add(new Car(0));
        }
        this.cars=cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
