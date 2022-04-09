import racingcar.Car;
import racingcar.Race;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final int RANGE_LIST_START_NUMBER = 0;
    private static final int MAINTAIN_RACE_TIME_FOR_MILLISECOND = 1000;

    public static void printCarsMoveState(List<Car> carList, int tryCount) throws InterruptedException {
        for (int count = 0; count < tryCount; count++) {
            Race.carsAddMove(carList);
            carList.forEach(ResultView::print);
            System.out.println();
            Thread.sleep(MAINTAIN_RACE_TIME_FOR_MILLISECOND);
        }
    }

    private static void print(Car car) {
        IntStream.range(RANGE_LIST_START_NUMBER, car.getMoveCount())
                .mapToObj(count -> "-")
                .forEach(System.out::print);
        System.out.println();
    }
}
