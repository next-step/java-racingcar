package stage4;

import java.util.ArrayList;
import java.util.List;

public class CarApplication {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        final InputValue ipValue = inputView.input();
        final String[] carNames = ipValue.getCarNames();
        final int numberOfCars = carNames.length;
        final int numberOfTries = ipValue.getTryNum();

        List<CarService> cars = init(carNames);

        final List<ResultValue> results = execute(numberOfTries, cars);
        resultView.printResult(numberOfCars, results);
    }

    private static List<ResultValue> execute(int tryNum, List<CarService> carList) {
        List<ResultValue> result = new ArrayList<>();
        for (int i = 0; i < tryNum; i++) {
            for (CarService cs : carList) {
                final int condition = cs.getCondition();
                cs.tryForward(condition);
                result.add(new ResultValue(cs.getCar().getName(), cs.getStatus()));
            }
        }
        return result;
    }

    private static List<CarService> init(String[] carNames) {
        List<CarService> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new CarService(new Car(carNames[i])));
        }
        return carList;
    }
}
