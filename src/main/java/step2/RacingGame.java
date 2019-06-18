package step2;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> carList;

    public RacingGame(int carNumber) {
        CreateCarList(carNumber);
    }

    private void CreateCarList(int carNumber){
        carList = new ArrayList <>();
        while (carNumber > 0) {
            carList.add(new Car());
            carNumber--;
        }
    }

    public List<Car> move() {
        carList.forEach((car) -> car.carPositionUpdate());
        return carList;
    }

}