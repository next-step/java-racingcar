package CarRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarList {
    Random random = new Random();

    private List<Car> carList = new ArrayList<Car>();

    public void addCar(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
    }

    public int getCarCount() {
        return carList.size();
    }

    public void movingCarList() {
        carList.forEach(car -> car.carMove(random.nextInt(10)));
    }
    public void getCarListDistance() {
        carList.forEach(car -> System.out.println(car.getCarMovingDistance()));
    }

}
