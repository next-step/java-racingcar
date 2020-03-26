package fifthrefactoring.domain;

import fifthrefactoring.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
            car.setStrategy(new RandomStrategy());
            carList.add(car);
        }

        return carList;
    }

    public static void moveCar(List<Car> carList) {
        for (Car car : carList) {
            car.moveCar(car.move());
        }
    }

    public static String setRank(List<Car> carList) {
        Collections.sort(carList);

        int maxPosition = carList.get(carList.size()-1).getCarPosition();

        return carList.stream()
                .filter(d -> d.getCarPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }
}