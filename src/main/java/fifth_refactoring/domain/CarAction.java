package fifth_refactoring.domain;

import fifth_refactoring.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class CarAction {

    public static List<Car> ready(String carName){
        String[] carNameArray = splitCarName(carName);

        return setCar(carNameArray);
    }

    public static String[] splitCarName(String carName) {
        return carName.split(InputView.CAR_NAME_SPLIT_SIGN);
    }

    public static List<Car> setCar(String[] carNameArray) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameArray) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }

    public static void moveCar(List<Car> carList) {
        for (Car car : carList) {
            car.setStrategy(new RandomStrategy());
            car.moveCar(car.move());
        }
    }
}