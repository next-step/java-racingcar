package carracing.view;

import carracing.model.Car;
import carracing.model.Cars;
import java.util.Collections;

public class ResultView {

    private static final long TIMER = 1000;
    private static final String DASH = "-";
    private static final String EMPTY = "";
    private static final String DELIMITER = " : ";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    private final Cars cars;

    public ResultView(Cars cars) {
        this.cars = cars;
    }

    public void outputGameResults() throws InterruptedException {
        System.out.println("실행 결과");

        for (int i = 1; i <= cars.getTryTotalCount(); i++) {
            Thread.sleep(TIMER);
            this.outputCarsHistory(i);
        }

        System.out.println(String.format(WINNER_MESSAGE, cars.getWinners()));
    }

    private void outputCarsHistory(Integer toIndex) {
        for (int i = 0; i < cars.getSize(); i++) {
            Car car = cars.getCar(i);
            System.out.println(carsHistoryToString(car, toIndex));
        }
        System.out.println();
    }

    private String carsHistoryToString(Car car, Integer toIndex) {
        Integer count = car.getSuccessCountByIndex(toIndex).intValue();
        return car.getName() + DELIMITER + String.join(EMPTY, Collections.nCopies(count, this.DASH));
    }
}
