package racing.domain;


import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(int cntOfCar) {
        setCarList(cntOfCar);
    }

    public Cars(String[] names) {
        setCarList(names);
    }

    private void setCarList(String[] names) {
        carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
    }
    private void setCarList(int cntOfCar) {
        carList = new ArrayList<>();
        for (int i = 0; i < cntOfCar; i++) {
            carList.add(new Car(""));
        }
    }

    public void moveCar(Moving moving) {
        for (Car car : carList) {
            car.move(moving.moveRandomNumber());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
