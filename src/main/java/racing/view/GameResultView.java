package racing.view;

import racing.domain.Car;
import racing.util.PositionRecordPrinter;
import racing.domain.Cars;

public class GameResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    private final Cars cars;
    private final int count;

    public GameResultView(Cars cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < count; i++) {
            printGame(i);
            System.out.println();
        }
    }

    private void printGame(int index) {
        for (Car car : cars.getCars()) {
            PositionRecordPrinter.print(car.getPositionRecord(), index);
        }
    }
}
