package step3.application;

import step3.domain.car.Car;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class RacingTrack {

    private static final String TRACE_SHAPE = "-";
    private static final String NOT_STARTED_CAR_TRACE_SHAPE = ".";

    private final Integer[][] traceArray;
    private final int carCount;
    private final int round;

    public static void showRacing(List<Car> cars) {
        RacingTrack racingTrack = new RacingTrack(cars);
        racingTrack.showRacing();
    }

    private RacingTrack(List<Car> cars) {
        checkArgument(!isEmpty(cars), "cars is required");
        this.traceArray = toArray(cars);
        this.carCount = traceArray.length;
        this.round = traceArray[0].length;
    }

    private boolean isEmpty(List<Car> cars) {
        return cars == null || cars.isEmpty();
    }

    private Integer[][] toArray(List<Car> cars) {
        return cars.stream()
                .map(Car::readTrace)
                .map(trace -> trace.toArray(new Integer[0]))
                .toArray(Integer[][]::new);
    }

    private void showRacing() {
        System.out.println("실행 결과");
        for (int currentRound = 0; currentRound < round; currentRound++) {
            showRound(currentRound);
            System.out.println();
        }
    }

    private void showRound(int currentRound) {
        for (int currentCar = 0; currentCar < carCount; currentCar++) {
            showCarTrace(currentCar, currentRound);
            System.out.println();
        }
    }

    private void showCarTrace(int currentCar, int currentRound) {
        Integer distinct = traceArray[currentCar][currentRound];
        if (distinct == 0) {
            System.out.print(NOT_STARTED_CAR_TRACE_SHAPE);
            return;
        }

        for (int currentPosition = 0; currentPosition < distinct; currentPosition++) {
            System.out.print(TRACE_SHAPE);
        }
    }

}
