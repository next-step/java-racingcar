import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    public List<Car> carList;

    private final Random random;

    public CarRacing(int carCount, int moveCount) {
        carList = new ArrayList();
        random = new Random();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(moveCount));
        }
    }

    public void moveAllCar() {
        for (Car car : carList) {
            car.move(random.nextInt(10));
        }
    }
}
