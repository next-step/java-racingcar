package racing.domain;


import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(String[] names) {
        setCarList(names);
    }

    private void setCarList(String[] names) {
        carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
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
