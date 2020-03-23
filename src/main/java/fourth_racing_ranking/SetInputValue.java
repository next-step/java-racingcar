package fourth_racing_ranking;

import fourth_racing_ranking.InputView;
import fourth_racing_ranking.Car;
import fourth_racing_ranking.CarAction;

import java.util.ArrayList;
import java.util.List;

public class SetInputValue {
    private static final CarAction carAction = new CarAction();
    private Resultview resultview = new Resultview();

    public List<Car> ready(String carName){
        String[] carNameArray = splitCarName(carName);

        List<Car> carList = setCar(carNameArray);

        return carList;
    }

    public static String[] splitCarName(String carName) {
        return carName.split(InputView.CAR_NAME_SPLIT_SIGN);
    }

    public List<Car> setCar(String[] carName) {
        List<Car> carList = new ArrayList<>();

        resultview.getTitle();

        for (int i = 0; i < carName.length; i++) {
            Car car = new Car();
            car.setCarName(carName[i]);
            resultview.draw(car);
            carList.add(car);
        }

        return carList;
    }
}
