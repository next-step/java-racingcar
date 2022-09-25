package step3.service;

import java.util.ArrayList;
import java.util.List;

import step3.domain.Car;

public class CarPlay {


    private final InputView inputView;
    private final Car car;
    private List<Car> carList;



    public CarPlay(Car car, InputView inputView) {
        this.inputView = inputView;
       this.car = car;
    }

    public List<Car> setCarList() {

        List<Car> carList = new ArrayList<>();

        if (checkAccumulatedListNull(this.carList)) {
            for (int i = 0; i < inputView.getCarNumber(); i++) {
                Car newCar = new Car();
                carList.add(newCar.returnCar());
            }
            this.carList = carList;
            return this.carList;
        }

        for (int i = 0; i < inputView.getCarNumber(); i++) {
            this.carList.set(i, this.carList.get(i).returnCar());
        }
        return this.carList;
    }

    private boolean checkAccumulatedListNull(List<Car> checkList) {
        return checkList == null;
    }

}
