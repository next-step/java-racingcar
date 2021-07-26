package CarRacing;

import java.util.List;
import java.util.Random;

public class CarRacing {
    private CarList carList = new CarList();
    private Random random = new Random();
    private int carCount;

    public CarRacing(int carCount) {
        this.carCount = carCount;
        setCarList();
    }

    private void setCarList() {
        if (carCount < 0) {
            throw new IllegalArgumentException("자동차 개수는 음수는 허용하지 않습니다.");
        }
        carList.addCarCount(carCount);
    }

    public List<Car> getCarList() {
        return carList.getCarList();
    }

    public void moveCarList() {
        carList.getCarList().forEach(car -> car.move(random.nextInt(10)));
    }
}
