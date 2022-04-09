package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private static final int CHECK_CAR_OR_TRY_COUNT = 0;
    private static final int RANGE_START_RANDOM_NUMBER = 0;
    private static final int RANGE_LIST_START_NUMBER = 0;
    private static final int RANGE_END_RANDOM_NUMBER = 9;
    private static final int MOVE_CONDITION = 4;
    private static final int MAINTAIN_RACE_TIME_FOR_MILLISECOND = 1000;

    public static void start(int carCount, int tryCount) throws InterruptedException {
        countValidate(carCount, tryCount);

        List<Car> carList = IntStream
                .range(RANGE_LIST_START_NUMBER, carCount)
                .mapToObj(count -> new Car(RANGE_START_RANDOM_NUMBER
                        , RANGE_END_RANDOM_NUMBER
                        , MOVE_CONDITION))
                .collect(Collectors.toList());

        carRaceUntilTryCount(carList, tryCount);
    }

    private static void countValidate(int carCount, int tryCount) {
        if (checkCount(carCount)) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 경주 할 수 있습니다.");
        }

        if (checkCount(tryCount)) {
            throw new IllegalArgumentException("경주 횟수는 최소 1번 이상이어야 경주 할 수 있습니다.");
        }
    }

    private static boolean checkCount(int count) {
        return count <= CHECK_CAR_OR_TRY_COUNT;
    }

    private static void carRaceUntilTryCount(List<Car> carList, int tryCount) throws InterruptedException {
        System.out.println("\n실행 결과");

        for (int count = 0; count < tryCount; count++) {
            carList.forEach(Car::addMoveCount);
            printCarsMoveState(carList);
            Thread.sleep(MAINTAIN_RACE_TIME_FOR_MILLISECOND);
        }
    }

    private static void printCarsMoveState(List<Car> carList) {
        carList.forEach(Race::print);
        System.out.println();
    }

    private static void print(Car car) {
        IntStream.range(RANGE_LIST_START_NUMBER, car.getMoveCount())
                .mapToObj(count -> "-")
                .forEach(System.out::print);
        System.out.println();
    }
}
