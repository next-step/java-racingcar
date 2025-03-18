package racing.view;

import java.util.List;
import racing.model.Car;
import racing.model.Cars;

public class OutputView {

    public static final String RESULT_LABEL = "실행 결과";

    public static void printResultLabel() {
        System.out.println(RESULT_LABEL);
    }

    public static void printResult(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
