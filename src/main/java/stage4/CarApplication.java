package stage4;

import java.util.ArrayList;
import java.util.List;

public class CarApplication {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        final InputValue ipValue = inputView.input();
        final int carNum = ipValue.getCarNum();
        final int tryNum = ipValue.getTryNum();

        List<CarService> carList = init(carNum);

        final List<ResultValue> results = execute(tryNum, carList);
        resultView.printResult(carNum, results);
    }

    private static List<ResultValue> execute(int tryNum, List<CarService> carList) {
        List<ResultValue> result = new ArrayList<>();
        for (int i = 0; i < tryNum; i++) {
            for (CarService cs : carList) {
                final int condition = cs.getCondition();
                cs.tryForward(condition);
                result.add(new ResultValue(cs.getStatus()));
            }
        }
        return result;
    }

    private static List<CarService> init(int carNum) {
        List<CarService> carList = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            carList.add(new CarService(new Car()));
        }
        return carList;
    }
}
