package car.step3;

import java.util.List;

public class ResultView {

    private final String DASH = "-";
    public void result(List<Car> carList) {
        for (Car car : carList) {
            String printCarLocation = DASH.repeat(car.location());
            System.out.println(printCarLocation);
        }
    }
}
