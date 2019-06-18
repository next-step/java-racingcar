package step2;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(int carNumber) {
        CreateCars(carNumber);
    }

    public List<Car> move() {
        cars.forEach((car) -> {
            int carPositionStatusNumber = Utils.createRandomNumber();
            car.carPositionUpdate(carPositionStatusNumber);
        });
        return cars;
    }

    private void CreateCars(int carNumber){
        cars = new ArrayList <>();
        while (carNumber > 0) {
            cars.add(new Car());
            carNumber--;
        }
    }

}