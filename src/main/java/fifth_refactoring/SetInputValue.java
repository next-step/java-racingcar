package fifth_refactoring;

import java.util.ArrayList;
import java.util.List;

public class SetInputValue {
    private static final CarAction carAction = new CarAction();
    private ResultView resultView = new ResultView();

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

        resultView.getTitle();

        for (int i = 0; i < carName.length; i++) {
            Car car = new Car();
            car.setCarName(carName[i]);
            resultView.draw(car);
            carList.add(car);
        }

        return carList;
    }
}
