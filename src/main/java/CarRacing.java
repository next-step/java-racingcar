import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    public List<Car> carList;

    public int remainMoveCount;

    private final Random random;

    public CarRacing(int carCount, int moveCount) {
        carList = new ArrayList();
        random = new Random();
        remainMoveCount = moveCount;

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void moveAllCar() {
        if (remainMoveCount <= 0) throw new RuntimeException("out of move count");
        remainMoveCount--;
        for (Car car : carList) {
            car.move();
        }
    }
}
