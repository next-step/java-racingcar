package step3.service;

import java.util.ArrayList;
import java.util.List;

import step3.domain.Car;

public class CarPlay {

    private final InputView inputView;
    private List<Car> carList;

    public CarPlay(InputView inputView) {
        this.inputView = inputView;
    }

    public void convertCarStatusToPrint(InputView inputView) {

        List<Car> updateCarList = this.setCarList();

        for (int i = 0; i < inputView.getCarNumber(); i++) {
            for (int j = 0; j < updateCarList.get(i).getCurrentStatus(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private List<Car> setCarList() {

        List<Car> carList = new ArrayList<>();

        if (checkAccumulatedListNull(this.carList)) {
            for (int i = 0; i < inputView.getCarNumber(); i++) {
                Car newCar = new Car();
                carList.add(newCar.carAction());
            }
            this.carList = carList;
            return this.carList;
        }

        for (int i = 0; i < inputView.getCarNumber(); i++) {
            this.carList.set(i, this.carList.get(i).carAction());
        }
        return this.carList;
    }

    private boolean checkAccumulatedListNull(List<Car> checkList) {
        return checkList == null;
    }
}
