package racing.view;

import org.apache.commons.lang3.StringUtils;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class OutputView {

    public static final String POSITION_BAR = "-";

    private OutputView() {
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printResult(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(car -> System.out.println(StringUtils.repeat(POSITION_BAR, car.getPosition())));

        System.out.println();
    }
}
