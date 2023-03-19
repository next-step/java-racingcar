package racingcargame;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private int carCount = 0;
    private List<Car> cars;

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCars(int carCount) {
        List<Car> carList = new ArrayList<Car>();
        InputView inputView = new InputView();
        for (int i = 0; i < carCount; i++) {
            Car car = new Car(inputView.inputCarName(i + 1));
            carList.add(car);
        }
        this.cars = carList;
    }

    public List<Car> getCars() {
        return cars;
    }
}
