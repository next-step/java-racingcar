package step4.view.output;

import step4.model.Car;
import step4.model.Cars;
import step4.model.Winners;

public class OutputViewImpl implements OutputView {

    private static final String TRACE = "-";

    @Override
    public void printRacingResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : %s%n", car.getName(), TRACE.repeat(car.getMoveCnt()));
        }
        System.out.println();
    }

    @Override
    public void printWinner(Winners winners) {
        System.out.printf("%s가 최종우승자입니다.", winners.getWinners());
    }
}
