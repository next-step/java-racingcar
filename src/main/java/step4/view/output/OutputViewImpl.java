package step4.view.output;

import step4.model.Car;
import step4.model.Cars;

public class OutputViewImpl implements OutputView {

    private static final String TRACE = "-";

    @Override
    public void printRacingResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : %s%n", car.getName(), TRACE.repeat(car.getPosition()));
        }
        System.out.println();
    }

    @Override
    public void printWinner(String winners) {
        System.out.printf("%s가 최종우승자입니다.", winners);
    }
}
