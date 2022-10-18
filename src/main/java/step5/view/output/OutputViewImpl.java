package step5.view.output;

import step5.model.Car;
import step5.model.Cars;

public class OutputViewImpl implements OutputView {

    private static final String TRACE = "-";

    @Override
    public void printRacingResult(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : %s%n", car.getName(), TRACE.repeat(car.getPosition()));
        }
        System.out.println();
    }

    @Override
    public void printWinner(final String winners) {
        System.out.printf("%s가 최종우승자입니다.", winners);
    }
}
