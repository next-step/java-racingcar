package step4.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    protected List<Car> carList;
    private CarsStrategy carsMethod;

    public Cars(CarsStrategy carsMethod) {
        this.carsMethod = carsMethod;
    }

    public Cars(List<Car> carList, CarsStrategy carsMethod) {
        this.carList = carList;
        this.carsMethod = carsMethod;
    }

    protected void makeCars(Car... cars) {
        carList = new ArrayList<Car>();
        for (Car car : cars) {
            carList.add(car);
        }
    }

    public List<Car> getCarList() {
        stateCheck();
        return this.carList;
    }

    public void moveCars() {
        stateCheck();
        carsMethod.move(this);
    }

    public void stateCheck() {
        if (carList == null || carList.size() == 0) {
            throw new IllegalStateException("주행할 자동차가 없습니다.");
        }
    }

    public List<Car> arrangeCars() {
        stateCheck();
        carList = carsMethod.arrange(this.carList);
        return carList;
    }
}
