package step3;

import sun.tools.jconsole.OutputViewer;

import java.util.List;

public class CarList {

    private List<Car> carList;

    private CarList(List<Car> carList) {
        this.carList = carList;
    }

    public static CarList from(List<Car> carList) {
        return new CarList(carList);
    }

    public void nextPosition() {
        for(Car car : carList) {
            car.goForward();
        }
    }

    public void displayCurrentPosition(OutputView outputView) {
        outputView.displayCarList(carList);
    }
}
