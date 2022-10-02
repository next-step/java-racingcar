import java.util.ArrayList;
import java.util.List;

public class CarRacingExecutor {

    public List<Car> carList;

    public CarRacingExecutor(int carCount) {
        carList = new ArrayList();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void proceedNextRound() {
        carList.forEach(Car::move);
    }
}
